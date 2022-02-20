package com.fp.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.auth.entity.UserAuthEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuthEntity> {

    List<UserAuthEntity> selectAll();
}
