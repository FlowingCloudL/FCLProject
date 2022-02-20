package com.fp.gateway.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.util.SaResult;
import com.fp.gateway.filter.SaIdTokenFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sa-Token 权限认证 配置类
 */

@Configuration
public class SaTokenConfig {

    // 注册 Sa-Token 全局过滤器, 解决跨域问题
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截与排除 path
                .addInclude("/**").addExclude("/favicon.ico")
                // 全局认证函数
                .setAuth(obj -> {})
                // 异常处理函数
                .setError(e -> SaResult.error(e.getMessage()))
                // 前置函数处理跨域：在每次认证函数之前执行
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*");

                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(saRouterStaff -> System.out.println("-------- OPTIONS预检请求，不做处理"))
                            .back();
                });
    }

    // 添加Id-Token
    @Bean
    public GlobalFilter saIdTokenFilter() {
        return new SaIdTokenFilter();
    }
}
