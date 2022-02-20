package com.fp.blog.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.id.SaIdUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Sa-Token 权限认证 配置类 
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    // 注册 Sa-Token 全局过滤器 
//    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico")
                .setAuth(obj -> {
                    // 校验 Id-Token 身份凭证     —— 以下两句代码可简化为：SaIdUtil.checkCurrentRequestToken(); 
                    String token = SaHolder.getRequest().getHeader(SaIdUtil.ID_TOKEN);
                    SaIdUtil.checkToken(token);
                })
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                });
    }
}