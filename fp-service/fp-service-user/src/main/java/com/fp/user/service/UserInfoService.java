package com.fp.user.service;

import com.fp.user.dto.PageVO;
import com.fp.user.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {

    //查询
    List<UserInfoEntity> queryUserInfoList();
    PageVO<UserInfoEntity> queryUserInfoListByPage(Integer pageNum, Integer pageSize);
    UserInfoEntity queryUserInfoByUid(Integer uid);
    UserInfoEntity queryUserInfoByNickname(String nickname);

    //修改
    boolean updateUserInfo(UserInfoEntity userInfo);

}
