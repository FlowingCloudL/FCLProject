package com.fp.mall.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fp.common.core.model.ResponseVO;
import com.fp.mall.order.mapper.OrderInfoMapper;
import com.fp.mall.order.model.dto.OrderSubmitDTO;
import com.fp.mall.order.model.entity.OrderInfoEntity;
import com.fp.mall.order.model.vo.OrderInfoVO;
import com.fp.mall.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderService orderService;

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
}
