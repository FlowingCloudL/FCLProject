package com.fp.auth.service;

import cn.dev33.satoken.util.SaResult;

public interface AuthService {

    SaResult doLogin(String lid, String identity, String credentials);

    boolean loginByUid(Integer uid, String pwd);
}
