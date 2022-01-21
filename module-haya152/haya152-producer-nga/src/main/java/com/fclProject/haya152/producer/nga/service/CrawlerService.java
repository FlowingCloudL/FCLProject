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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Service
public class CrawlerService {

    @Autowired
    private NgaMapper ngaMapper;

    @Autowired
    private SaveService saveService;

    @Value("${nga.url}")
    private String url;

    @Value("${nga.cookieName}")
    private String cookieName;

    @Value("${nga.cookieValue}")
    private String cookieValue;

    @Value("${nga.building}")
    private String no;

    private WebClient webClient;


    public void startCrawler() {

        System.out.printf("\n爬虫服务初始化中。。。。。\n");
        System.out.println("url:"+url);
        System.out.println("cookieName:"+cookieName);
        System.out.println("cookieValue:"+cookieValue);

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
        System.out.println("=====================================");
        System.out.println("             爬虫开始运行              ");
        System.out.println("=====================================");

        Runnable task = () -> {
            try {
                crawler(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println("定时任务： "+url+"   目标："+no+"   开始执行！");
        service.scheduleAtFixedRate(task,10,10, TimeUnit.SECONDS);
    }

    public void crawler(String url) throws IOException {
        int startPage = ngaMapper.selectMaxFloor(no) / 20 - 1;
//        int startPage = 1;
        startPage = startPage > 0 ? startPage : 1;
        System.out.println("=====================================");
        crawByPage(url,startPage,startPage+20);
    }

    public void crawByPage(String url,int startPage, int endPage) throws FailingHttpStatusCodeException, IOException {
        for (int i = startPage; i <= endPage; i++){
            System.out.println("爬取: "+url+"&page="+i+"    |    "+i+"P");
            HtmlPage page = webClient.getPage(url+"&page="+i);
            webClient.waitForBackgroundJavaScript(1 * 1000);    // 等待js后台执行1秒
            try {
                List<NgaDto> list = ParseUtils.parseNGAByPage(page.asXml());
                saveService.saveToMysqlByInsert(list,no);
            } catch (NullPointerException e) {
                System.out.println("【NullPointerException】重试。。。");
                i--;
            }
        }
    }
}
