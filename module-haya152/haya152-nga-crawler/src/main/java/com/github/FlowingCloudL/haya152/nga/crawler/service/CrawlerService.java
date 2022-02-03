package com.github.FlowingCloudL.haya152.nga.crawler.service;

import com.github.FlowingCloudL.haya152.nga.crawler.dao.NGAMapper;
import com.github.FlowingCloudL.haya152.nga.crawler.entity.NGACommentsEntity;
import com.github.FlowingCloudL.haya152.nga.crawler.utils.ParseUtils;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CrawlerService {

    private final Environment environment;
    private final NGAMapper ngaMapper;
    private final SaveService saveService;
    private final ThreadLocal<WebClient> webClientThreadLocal = new ThreadLocal<>();
    private final String url;
    private final String buildingTableName;

    @Autowired
    public CrawlerService(Environment env,
                          NGAMapper ngaMapper,
                          SaveService saveService) {

        this.environment = env;
        this.ngaMapper = ngaMapper;
        this.saveService = saveService;
        Integer buildingNo = Integer.parseInt(env.getProperty("nga.buildingNo"));
        this.url = ngaMapper.selectBuildingUrl(buildingNo);
        this.buildingTableName = ngaMapper.selectBuildingTableName(buildingNo);
    }

    private void initialWebClient() {

        log.info("初始化WebClient......");

        String cookieName = environment.getProperty("nga.cookieName");
        String cookieValue = environment.getProperty("nga.cookieValue");
        log.info("[cookieName]: "+cookieName);
        log.info("[cookieValue]: "+cookieValue);

        // HtmlUnit 模拟浏览器
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getCookieManager().setCookiesEnabled(true);
        webClient.getCookieManager().addCookie(new Cookie("bbs.nga.cn", cookieName, cookieValue));
        webClient.getOptions().setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
        webClient.getOptions().setCssEnabled(false);                    // 禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10 * 1000);                   // 设置连接超时时间

        webClientThreadLocal.set(webClient);
        log.info("WebClient初始化完成!");
    }

    private WebClient getWebClient() {
        if (webClientThreadLocal.get() == null) initialWebClient();
        return webClientThreadLocal.get();
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 1000 * 30)
    public void crawlerLatest() {
        int startPage = ngaMapper.selectMaxFloor(buildingTableName) / 20 - 3;
        startPage = startPage > 0 ? startPage : 1;
        int endPage = startPage + 10;
        log.info("定时任务 - crawlerLatest  |  楼号 - "+buildingTableName+"  |  "+startPage+"-"+endPage+"P  |  启动成功！");
        crawByPage(url, buildingTableName, startPage, endPage);
    }

    @Scheduled(cron = "0 0 4 * * ?")
    public void crawlerBack() {
        int backOffset = 1000;
        int endPage = ngaMapper.selectMaxFloor(buildingTableName) / 20 - 1;
        int startPage = endPage - backOffset;
        startPage = startPage > 0 ? startPage : 1;
        log.info("定时任务 - crawlerBack  |  楼号 - "+buildingTableName+"  |  "+startPage+"-"+endPage+"P  |  启动成功！");
        crawByPage(url, buildingTableName, startPage, endPage);
    }

    @Async
    public void crawlerAsync(int no, int startPage, int endPage) {
        String url = ngaMapper.selectBuildingUrl(no);
        String tableName = ngaMapper.selectBuildingTableName(no);

        startPage = startPage > 0 ? startPage : 1;

        log.info("异步任务 - crawlerAsync  |  楼号 - "+tableName+"  |  "+startPage+"-"+endPage+"P  |  启动成功！");
        crawByPage(url, tableName, startPage, endPage);
    }

    public void crawByPage(String url, String buildingTableName, int startPage, int endPage) {
        WebClient webClient = getWebClient();
        for (int i = startPage; i <= endPage; i++){
            try {
                HtmlPage page = webClient.getPage(url+"&page="+i);
                webClient.waitForBackgroundJavaScript(1 * 1000); // 等待js后台执行1秒
                try {
                    List<NGACommentsEntity> list = ParseUtils.parseNGAByPage(page.asXml(), buildingTableName);
                    saveService.saveToMysql(list);
                } catch (NullPointerException e) {
                    log.error("发生NullPointerException！！！！！");
                }
            } catch (Exception ex) {
                log.error("发生未知错误！！！！！");
            }
        }
        log.info("楼号 - "+buildingTableName+"  |  url - "+url+"  |  "+startPage+"-"+endPage+"P  |  执行完成！");
    }
}
