package com.fp.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fp.auth.mapper.UserAuthMapper;
import com.fp.auth.entity.UserAuthEntity;
import com.fp.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAuthMapper mapper;

    @Override
    public SaResult doLogin(String lid, String identity, String credentials) {
        try {
            if(Integer.parseInt(lid) == 1 && loginByUid(Integer.parseInt(identity),credentials)) {
                StpUtil.login(identity);
                return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
            }
            return SaResult.error("！");
        } catch (NumberFormatException e) {
            return SaResult.error("登录信息格式错误！");
        }
    }

    @Override
    public boolean loginByUid(Integer uid, String pwd) {
        try {
            List<Object> list = mapper.selectObjs(new QueryWrapper<UserAuthEntity>()
                    .select("credentials").eq("lid", 1).eq("identity", uid));
            if (list.get(0).equals(pwd)) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
