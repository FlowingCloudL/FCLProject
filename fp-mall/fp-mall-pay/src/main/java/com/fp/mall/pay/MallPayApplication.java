package com.fp.mall.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MallPayApplication {

    public static void main(String[] args) {

        SpringApplication.run(MallPayApplication.class, args);

    }
}
