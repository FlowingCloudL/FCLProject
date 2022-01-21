package com.fclProject.haya152.producer.nga;

import com.fclProject.haya152.producer.nga.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Autowired
    CrawlerService crawlerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("开始执行爬虫服务");
        crawlerService.startCrawler();
    }
}