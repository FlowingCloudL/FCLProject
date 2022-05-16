package com.fp.mall.order.service;

import com.fp.mall.order.model.dto.OrderSubmitDTO;

/**
 * 订单业务
 *
 * @author FlowingCloudL
 * @date 2022/5/11 16:10
 */
public interface OrderService {

    /**
     * 提交订单，返回订单id
     * @param uid 用户id
     * @param orderSubmitDTO 订单提交DTO
     * @return 订单id
     */
    Long submitOrder(Long uid, OrderSubmitDTO orderSubmitDTO);

    /**
     * 超时关闭订单, 只有订单未支付时才能成功
     * @param uid 用户id
     * @param orderId 订单id
     */
    void closeOrder(Long uid, Long orderId);


}
