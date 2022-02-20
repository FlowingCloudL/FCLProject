package com.fp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.user.dto.PageVO;
import com.fp.user.entity.UserInfoEntity;
import com.fp.user.mapper.UserInfoMapper;
import com.fp.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoEntity> queryUserInfoList() {
        return userInfoMapper.selectList(null);
    }

    @Override
    public PageVO<UserInfoEntity> queryUserInfoListByPage(Integer pageNum, Integer pageSize) {

        Page<UserInfoEntity> page = userInfoMapper.selectPage(new Page<>(pageNum, pageSize), null);
        PageVO<UserInfoEntity> vo = new PageVO<>();
        vo.setPageNum(pageNum);
        vo.setPageSize(pageSize);
        vo.setTotal(page.getTotal());
        vo.setDataList(page.getRecords());
        return vo;
    }

    @Override
    public UserInfoEntity queryUserInfoByUid(Integer uid) {
        return userInfoMapper.selectById(uid);
    }

    @Override
    public UserInfoEntity queryUserInfoByNickname(String nickname) {
        return userInfoMapper.selectOne(new QueryWrapper<UserInfoEntity>().eq("nickname",nickname));
    }

    @Override
    public boolean updateUserInfo(UserInfoEntity userInfo) {
        return userInfoMapper.updateById(userInfo) == 1;
    }
}
