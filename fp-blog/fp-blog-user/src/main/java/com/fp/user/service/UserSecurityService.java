package com.fp.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fp.user.dto.PageVO;
import com.fp.user.entity.UserSecurityEntity;

import java.util.List;

public interface UserSecurityService {

    //查询
    List<UserSecurityEntity> queryList(QueryWrapper<UserSecurityEntity> queryWrapper);
    PageVO<UserSecurityEntity> queryByPage(QueryWrapper<UserSecurityEntity> queryWrapper, Integer pageNum, Integer pageSize);

    //修改
    Integer update(UserSecurityEntity userSecurity);

    //增加
    Integer add(UserSecurityEntity userSecurity);

    //删除
    Integer delete(Integer lid, String identity);
    Integer deleteByUid(Integer uid);

}
