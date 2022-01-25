package com.fclProject.haya152.consumer.nga.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @ApiOperation("跳转到基础默认搜索页")
    @GetMapping ("/default")
    public String selectPage() {
        return "select";
    }

}
