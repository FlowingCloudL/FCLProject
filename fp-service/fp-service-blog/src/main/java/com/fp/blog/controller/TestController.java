package com.fp.blog.controller;

import com.fp.blog.service.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/t1/{msg}")
    public String test1(@PathVariable("msg") String msg) {
        return testFeign.testTest(msg);
    }

    @GetMapping("/t2/{msg}")
    public String test2(@PathVariable("msg") String msg) {
        return msg;
    }
}
