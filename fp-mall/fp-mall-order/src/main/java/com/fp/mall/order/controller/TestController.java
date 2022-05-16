package com.fp.mall.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fp.common.core.model.ResponseVO;
import com.fp.mall.order.mapper.OrderInfoMapper;
import com.fp.mall.order.model.dto.OrderSubmitDTO;
import com.fp.mall.order.model.entity.OrderInfoEntity;
import com.fp.mall.order.model.vo.OrderInfoVO;
import com.fp.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderService orderService;

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @GetMapping("/t1")
    public ResponseVO<List<OrderInfoVO>> test1() {
        List<OrderInfoEntity> entityList = orderInfoMapper.selectList(new QueryWrapper<>());
        List<OrderInfoVO> voList = new ArrayList<>(entityList.size());
        for (OrderInfoEntity entity : entityList) {
            OrderInfoVO vo = new OrderInfoVO();
            BeanUtils.copyProperties(entity, vo);
            voList.add(vo);
        }
        return ResponseVO.success(voList);
    }

    @PostMapping("/t2")
    public ResponseVO<Void> test2(@RequestBody OrderSubmitDTO orderSubmitDTO) {
        orderService.submitOrder(0L, orderSubmitDTO);
        return ResponseVO.success();
    }

    @GetMapping("/mq")
    public ResponseVO<Void> testMQ() {
        Message message = MessageBuilder
                .withPayload("测试延时消息  发送时间："+ LocalDateTime.now())
                .build();
        rocketMQTemplate.asyncSend("testTopic", message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("发送异常");
            }
        }, 3000, 5);
        return ResponseVO.success();
    }
}
