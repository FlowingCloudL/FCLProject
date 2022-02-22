package com.fp.user.service;

import com.fp.user.dto.PageVO;
import com.fp.user.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {

    //查询
    List<UserInfoEntity> queryList();
    PageVO<UserInfoEntity> queryListByPage(Integer pageNum, Integer pageSize);
    UserInfoEntity queryByUid(Integer uid);
    UserInfoEntity queryByNickname(String nickname);

    //修改
    Integer update(UserInfoEntity userInfo);

    //增加
    Integer add(UserInfoEntity userInfo);

    //删除
    Integer delete(Integer uid);

}
