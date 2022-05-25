package com.fp.mall.order.listener;

import com.alibaba.fastjson.JSONObject;
import com.fp.mall.order.model.bo.OrderCloseBO;
import com.fp.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RocketMQ 监听 - 订单关闭消息
 *
 * @author FlowingCloudL
 * @date 2022/5/16 19:12
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "fp-mall-order", selectorExpression = "close", consumerGroup = "fp-mall-order-group")
public class OrderCloseListener implements RocketMQListener<String> {

    @Resource
    private OrderService orderService;

    @Transactional
    @Override
    public void onMessage(String message) {
        log.info("[消息队列] 收到消息："+message);
        OrderCloseBO orderCloseBO = JSONObject.parseObject(message, OrderCloseBO.class);
        // 调用订单关闭服务 (天然具有幂等性)
        orderService.closeOrder(orderCloseBO.getUserId(), orderCloseBO.getOrderId());
        log.info("[消息队列] 超时订单关闭成功!  订单号:"+orderCloseBO.getOrderId());
    }

}