package com.fp.auth.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.sso.SaSsoConsts;
import com.fp.auth.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSOConfigurer {

    @Autowired
    private AuthServiceImpl authService;

    /**
     * 配置SSO相关参数
     */
    @Autowired
    private void configureSSO(SaTokenConfig cfg) {

        SaSsoConsts.ParamName.name = "identity";
        SaSsoConsts.ParamName.pwd = "credentials";

        // 配置：未登录时返回的View
        cfg.sso.setNotLoginView(() -> {
            String msg = "当前会话在SSO-Server端尚未登录，请先访问"
                    + "<a href='http://localhost:8080/fp-auth/sso/doLogin?lid=1&identity=1&credentials=123456' target='_blank'> doLogin登录 </a>"
                    + "进行登录之后，刷新页面开始授权";
            return msg;
        });

        // 配置：登录处理函数
        cfg.sso.setDoLoginHandle((identity,credentials) -> {
            SaRequest request = SaHolder.getRequest();
            String lid = request.getParam("lid");
            return authService.doLogin(lid,identity,credentials);
        });
    }
}
