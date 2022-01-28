package com.fclProject.haya152.producer.nga.service;

import com.fclProject.haya152.producer.nga.dao.NgaMapper;
import com.fclProject.haya152.producer.nga.dto.NgaDto;
import com.fclProject.haya152.producer.nga.utils.ParseUtils;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

@Service
public class CrawlerService {

    private final NgaMapper ngaMapper;
    private final SaveService saveService;
    private final WebClient webClient;
    private final String url;
    private final String buildingTableName;

    @Autowired
    public  CrawlerService(@Value("${nga.buildingNo}") Integer buildingNo,
                           @Value("${nga.cookieValue}") String cookieName,
                           @Value("${nga.cookieName}") String cookieValue,
                           NgaMapper ngaMapper,
                           SaveService saveService) {

        System.out.printf("\n===========================================================================================\n");
        System.out.printf("\n爬虫服务初始化中。。。。。\n\n");

        this.ngaMapper = ngaMapper;
        this.saveService = saveService;
        this.url = ngaMapper.selectBuildingUrl(buildingNo);
        this.buildingTableName = ngaMapper.selectBuildingTableName(buildingNo);

        System.out.println("[cookieName] :  "+cookieName);
        System.out.println("[cookieValue] :  "+cookieValue);

        // 屏蔽HtmlUnit等系统 log
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http.client").setLevel(Level.OFF);

        // HtmlUnit 模拟浏览器
        webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getCookieManager().setCookiesEnabled(true);
        webClient.getCookieManager().addCookie(new Cookie("bbs.nga.cn", cookieName, cookieValue));
        webClient.getOptions().setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
        webClient.getOptions().setCssEnabled(false);                    // 禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10 * 1000);                   // 设置连接超时时间

        System.out.printf("\n爬虫服务初始化完成!\n");
        System.out.printf("\n===========================================================================================\n\n");
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void crawlerLatest() throws IOException {
        int startPage = ngaMapper.selectMaxFloor(buildingTableName) / 20 - 1;
        startPage = startPage > 0 ? startPage : 1;
        crawByPage(startPage, startPage+10);
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void crawlerBack() throws IOException {
        int backOffset = 50;
        int endPage = ngaMapper.selectMaxFloor(buildingTableName) / 20 - 1;
        int startPage = endPage - backOffset;
        startPage = startPage > 0 ? startPage : 1;
        crawByPage(startPage, endPage);
    }

    public void crawByPage(int startPage, int endPage) throws FailingHttpStatusCodeException, IOException {
        for (int i = startPage; i <= endPage; i++){
            System.out.println("["+Thread.currentThread().getName()+"]    |    url: "+url+"&page="+i+"    |    "+i+"P");
            HtmlPage page = webClient.getPage(url+"&page="+i);
            webClient.waitForBackgroundJavaScript(1 * 1000);    // 等待js后台执行1秒
            try {
                List<NgaDto> list = ParseUtils.parseNGAByPage(page.asXml());
                saveService.saveToMysql(buildingTableName, list);
            } catch (NullPointerException e) {
                System.out.println("【NullPointerException】重试。。。");
                i--;
            }
        }
    }
}
