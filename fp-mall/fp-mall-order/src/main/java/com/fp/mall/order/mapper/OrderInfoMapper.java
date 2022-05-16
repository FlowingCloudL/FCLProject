package com.fp.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.order.model.entity.OrderInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfoEntity> {

    /**
     * 查询订单状态 (加锁)
     * @param orderId 订单id
     * @return 订单状态
     */
    Byte getOrderStatusForUpdate(@Param("orderId") Long orderId);

    /**
     * 修改订单状态
     * @param uid 用户id
     * @param orderId 订单id
     * @param status 订单状态
     */
    void updateOrderStatus(@Param("uid") Long uid, @Param("orderId") Long orderId, @Param("status") Byte status);

}
