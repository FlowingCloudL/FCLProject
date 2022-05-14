package com.fp.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.order.model.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItemEntity> {
}
