package com.fp.mall.order.service.impl;

import com.fp.mall.order.dto.ResponseDTO;
import com.fp.mall.order.entity.OrderEntity;
import com.fp.mall.order.exception.OrderException;
import com.fp.mall.order.exception.PayException;
import com.fp.mall.order.exception.StockException;
import com.fp.mall.order.feign.PayService;
import com.fp.mall.order.feign.StockService;
import com.fp.mall.order.mapper.OrderMapper;
import com.fp.mall.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PayService payService;

    @Autowired
    private StockService stockService;


    @GlobalTransactional()
    @Override
    public Integer createOrder(OrderEntity order) {

        order.setOrderId(null);

        // 扣减库存
        ResponseDTO stockDTO = stockService.reduce(order.getItemId(), order.getItemNum());
        if (stockDTO.getCode() == 500) throw new StockException();

        // 计算金额


        // 扣减余额
        ResponseDTO payDTO = payService.pay(order.getUid(), order.getOrderAmount());
        System.out.println(payDTO);
        if (payDTO.getCode() == 500) throw new PayException();

        // 持久化订单信息
        int i = orderMapper.insert(order);

        if (i > 0) {
            return order.getOrderId();
        }
        else throw new OrderException();

    }
}
