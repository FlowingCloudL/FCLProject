package com.fp.blog.service;

import org.springframework.stereotype.Component;

@Component
public class TestFallback implements TestFeign {

    @Override
    public String testTest(String msg) {
        return "服务出现故障, 维护中";
    }
}
