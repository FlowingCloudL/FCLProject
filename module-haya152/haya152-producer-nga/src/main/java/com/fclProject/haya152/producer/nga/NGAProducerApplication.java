package com.fclProject.haya152.producer.nga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NGAProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NGAProducerApplication.class, args);
    }
}
