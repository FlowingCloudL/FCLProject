package com.fp.user.service;

import com.fp.user.entity.UserInfoEntity;
import com.fp.user.entity.UserSecurityEntity;

public interface AdminService {

    //注册
    boolean register(UserInfoEntity userInfo, UserSecurityEntity userSecurity);

    //注销
    boolean logOff(Integer uid);
}
