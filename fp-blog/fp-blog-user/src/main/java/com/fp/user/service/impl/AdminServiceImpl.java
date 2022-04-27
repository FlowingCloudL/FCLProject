package com.fp.user.service.impl;

import com.fp.user.entity.UserInfoEntity;
import com.fp.user.entity.UserSecurityEntity;
import com.fp.user.service.AdminService;
import com.fp.user.service.UserInfoService;
import com.fp.user.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserSecurityService userSecurityService;

    @Override
    public boolean register(UserInfoEntity userInfo, UserSecurityEntity userSecurity) {
        userInfoService.add(userInfo);
        userSecurityService.add(userSecurity);
        return true;
    }

    @Override
    public boolean logOff(Integer uid) {
        userInfoService.delete(uid);
        userSecurityService.deleteByUid(uid);
        return true;
    }
}
