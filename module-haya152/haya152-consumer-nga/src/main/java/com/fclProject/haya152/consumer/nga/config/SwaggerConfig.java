package com.fclProject.haya152.consumer.nga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("HB专楼查询API")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fclProject.haya152.consumer.nga.controller"))
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("FlowingCloudL", "https://github.com/FlowingCloudL", "994288564@qq.com");
        return new ApiInfo(
                "NGA专楼数据库API", // 标题
                "获取HB专楼数据的API", // 描述
                "v1.0", // 版本
                "https://bbs.nga.cn/read.php?tid=30226559", // 组织链接
                contact, // 联系人信息
                "FCL 2.0 许可", // 许可
                "None", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}