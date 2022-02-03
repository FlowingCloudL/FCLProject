package com.github.FlowingCloudL.fclProject.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/test1/{msg}")
    public String test1(@PathVariable("msg") String msg) {
        return "msg:" + msg + "\nport:" + port;
    }
}
