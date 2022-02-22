package com.fp.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.user.entity.UserSecurityEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserSecurityMapper extends BaseMapper<UserSecurityEntity> {

}
