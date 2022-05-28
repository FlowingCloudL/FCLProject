package com.fp.mall.sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleApplication.class, args);
    }
}
