package com.fp.user.controller;

import com.fp.user.dto.ResponseDTO;
import com.fp.user.entity.UserInfoEntity;
import com.fp.user.entity.UserSecurityEntity;
import com.fp.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class UserAdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register/{userInfo}/{userSecurity}")
    public ResponseDTO register(@RequestBody @PathVariable("userInfo") UserInfoEntity userInfo,
                                @RequestBody @PathVariable("userSecurity") UserSecurityEntity userSecurity){

        adminService.register(userInfo, userSecurity);
        return ResponseDTO.getSuccess("注册成功");
    }

    @PostMapping("/logOff/{uid}")
    public ResponseDTO logOff(@RequestBody @PathVariable Integer uid){

        adminService.logOff(uid);
        return ResponseDTO.getSuccess("注销成功");
    }

}
