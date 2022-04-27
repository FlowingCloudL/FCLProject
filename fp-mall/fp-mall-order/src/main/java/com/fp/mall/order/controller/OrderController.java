package com.fp.mall.order.controller;

import com.fp.mall.order.dto.ResponseDTO;
import com.fp.mall.order.entity.OrderEntity;
import com.fp.mall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/create")
    public ResponseDTO payMoney(@RequestBody OrderEntity order) {

        Integer orderId = orderService.createOrder(order);
        return ResponseDTO.getSuccess("订单创建成功", orderId);

    }

}
