package com.fp.user.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.sso.SaSsoConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSOConfigurer {

    // 配置SSO相关参数
    @Autowired
    private void configSso(SaTokenConfig cfg) {
        // 自定义API地址
        //SaSsoConsts.ParamName.name = "/sso/auth";
        // ...

        // SSO 相关配置
        //cfg.sso.
    }
}
