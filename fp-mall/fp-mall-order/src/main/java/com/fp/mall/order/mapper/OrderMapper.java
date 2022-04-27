package com.fp.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

}
