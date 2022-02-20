package com.github.FlowingCloudL.haya152.nga.crawler.controller;

import com.github.FlowingCloudL.haya152.nga.crawler.dto.ResponseDTO;
import com.github.FlowingCloudL.haya152.nga.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    CrawlerService crawlerService;

    @RequestMapping("/crawler/add/{no}/{startPage}/{endPage}")
    @ResponseBody
    public ResponseDTO addAsyncCrawlerTask(@PathVariable("no") int no,
                                           @PathVariable("startPage") int startPage,
                                           @PathVariable("endPage") int endPage) {
        crawlerService.crawlerAsync(no,startPage,endPage);
        return new ResponseDTO(200,"异步爬虫任务已提交！","");
    }
}
