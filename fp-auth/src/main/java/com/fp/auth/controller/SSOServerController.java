package com.fp.auth.controller;

import cn.dev33.satoken.sso.SaSsoHandle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token-SSO Server端 Controller 
 */
@RestController
public class SSOServerController {

    /**
     * Sa-Token-SSO Server端 Controller
     */
    @RestController
    public class SsoServerController {

        // SSO-Server：统一认证地址
        @RequestMapping("/sso/auth")
        public Object ssoAuth() {
            return SaSsoHandle.ssoAuth();
        }

        // SSO-Server：RestAPI 登录接口
        @RequestMapping("/sso/doLogin")
        public Object ssoDoLogin() {
            return SaSsoHandle.ssoDoLogin();
        }

        // SSO-Server：校验ticket 获取账号id
        @RequestMapping("/sso/checkTicket")
        public Object ssoCheckTicket() {
            return SaSsoHandle.ssoCheckTicket();
        }

        // SSO-Server：单点注销
        @RequestMapping("/sso/logout")
        public Object ssoLogout() {
            return SaSsoHandle.ssoServerLogout();
        }

        // ... 其它方法

    }

}