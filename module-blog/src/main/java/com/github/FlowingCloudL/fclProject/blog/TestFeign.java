package com.github.FlowingCloudL.fclProject.blog;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-user", fallback = TestFallback.class, configuration = FeignConfiguration.class)
public interface TestFeign {

    @GetMapping("/test1/{msg}")
    String testTest(@PathVariable("msg") String msg);
}

class FeignConfiguration {
    @Bean
    public TestFallback testFallback() {
        return new TestFallback();
    }
}

class TestFallback implements TestFeign{

    @Override
    public String testTest(@PathVariable("msg") String msg) {
        return "服务出现故障, 维护中";
    }
}