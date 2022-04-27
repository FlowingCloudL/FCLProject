package com.fp.user.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.id.SaIdUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Sa-Token 权限认证 配置类
 */
@Configuration
public class SaTokenConfigurer implements WebMvcConfigurer {


    // 注册 Sa-Token 全局过滤器 - 验证 Id-Token
//    @Bean
    public SaServletFilter getSaServletFilter() {
        SaSession session = StpUtil.getSession();
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