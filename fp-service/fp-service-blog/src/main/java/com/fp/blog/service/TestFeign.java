package com.fp.blog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fp-user", fallback = TestFallback.class)
public interface TestFeign {

    @GetMapping("/testUser/{msg}")
    String testTest(@PathVariable("msg") String msg);
}