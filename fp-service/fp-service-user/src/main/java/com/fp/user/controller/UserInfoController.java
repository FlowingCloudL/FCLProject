package com.fp.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.user.dto.PageVO;
import com.fp.user.dto.ResponseDTO;
import com.fp.user.entity.UserInfoEntity;
import com.fp.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/info")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/query/list")
    public ResponseDTO queryUserInfoList() {
        try {
            List<UserInfoEntity> result = userInfoService.queryList();
            return ResponseDTO.getSuccess("查询成功", result);
        } catch (Exception e) {
            return ResponseDTO.getError("查询失败");
        }
    }

    @RequestMapping("/query/list/{pageNum}/{pageSize}")
    public ResponseDTO queryUserInfoList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        try {
            PageVO<UserInfoEntity> result = userInfoService.queryListByPage(pageNum, pageSize);
            return ResponseDTO.getSuccess("查询成功", result);
        } catch (Exception e) {
            return ResponseDTO.getError("查询失败");
        }
    }

    @RequestMapping("/query/uid/{uid}")
    public ResponseDTO queryUserInfoByUid(@PathVariable Integer uid) {
        try {
            UserInfoEntity result = userInfoService.queryByUid(uid);
            return ResponseDTO.getSuccess("查询成功", result);
        } catch (Exception e) {
            return ResponseDTO.getError("查询失败");
        }
    }

    @RequestMapping("/query/name/{name}")
    public ResponseDTO queryUserInfoByNickname(@PathVariable String name) {
        try {
            UserInfoEntity result = userInfoService.queryByNickname(name);
            return ResponseDTO.getSuccess("查询成功", result);
        } catch (Exception e) {
            return ResponseDTO.getError("查询失败");
        }
    }

    @RequestMapping("/update/")
    public ResponseDTO updateUserInfo(@RequestBody UserInfoEntity userInfo) {
        try {
            if (userInfoService.update(userInfo) > 0) {
                return ResponseDTO.getSuccess("更新成功");
            }
            return ResponseDTO.getError("更新失败");
        } catch (Exception e) {
            return ResponseDTO.getError("更新失败");
        }
    }

}
