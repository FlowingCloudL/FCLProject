package com.github.FlowingCloudL.haya152.nga.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class NGACrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NGACrawlerApplication.class, args);
    }
}
