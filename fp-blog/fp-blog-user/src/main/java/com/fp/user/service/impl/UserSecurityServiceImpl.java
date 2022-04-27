package com.fp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.user.dto.PageVO;
import com.fp.user.entity.UserSecurityEntity;
import com.fp.user.mapper.UserSecurityMapper;
import com.fp.user.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserSecurityMapper userSecurityMapper;

    @Override
    public List<UserSecurityEntity> queryList(QueryWrapper<UserSecurityEntity> queryWrapper) {
        return userSecurityMapper.selectList(queryWrapper);
    }

    @Override
    public PageVO<UserSecurityEntity> queryByPage(QueryWrapper<UserSecurityEntity> queryWrapper, Integer pageNum, Integer pageSize) {
        Page<UserSecurityEntity> list = userSecurityMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        PageVO<UserSecurityEntity> vo = new PageVO<>();
        vo.setPageNum(pageNum);
        vo.setPageSize(pageSize);
        vo.setTotal(list.getTotal());
        vo.setDataList(list.getRecords());
        return vo;
    }

    @Override
    public Integer update(UserSecurityEntity userSecurity) {
        UpdateWrapper<UserSecurityEntity> updateWrapper =
                new UpdateWrapper<UserSecurityEntity>().eq("lid", userSecurity.getLid()).eq("identity", userSecurity.getIdentity());
        return userSecurityMapper.update(userSecurity, updateWrapper);
    }

    @Override
    public Integer add(UserSecurityEntity userSecurity) {
        return userSecurityMapper.insert(userSecurity);
    }

    @Override
    public Integer delete(Integer lid, String identity) {
        return userSecurityMapper.delete(new QueryWrapper<UserSecurityEntity>().eq("lid", lid).eq("identity", identity));
    }

    @Override
    public Integer deleteByUid(Integer uid) {
        return userSecurityMapper.delete(new QueryWrapper<UserSecurityEntity>().eq("uid", uid));
    }
}
