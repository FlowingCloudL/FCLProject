package com.fp.mall.order.service.impl;

import com.fp.api.mall.product.model.OrderSpuBO;
import com.fp.api.mall.product.model.StockModifyBO;
import com.fp.api.mall.product.service.RemoteSpuService;
import com.fp.api.mall.product.service.RemoteStockService;
import com.fp.mall.order.consts.OrderStatusConst;
import com.fp.mall.order.mapper.OrderInfoMapper;
import com.fp.mall.order.mapper.OrderItemMapper;
import com.fp.mall.order.model.bo.OrderCloseBO;
import com.fp.mall.order.model.dto.OrderSubmitDTO;
import com.fp.mall.order.model.dto.OrderSubmitSkuDTO;
import com.fp.mall.order.model.entity.OrderInfoEntity;
import com.fp.mall.order.model.entity.OrderItemEntity;
import com.fp.mall.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @DubboReference
    private RemoteStockService remoteStockService;

    @DubboReference
    private RemoteSpuService remoteSpuService;

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GlobalTransactional
    @Override
    public Long submitOrder(Long uid, OrderSubmitDTO orderSubmitDTO) {

        // 扣减库存
        List<StockModifyBO> bos = orderSubmitDTO.getSkus().stream().map(dto -> {
            StockModifyBO bo = new StockModifyBO();
            BeanUtils.copyProperties(dto, bo);
            return bo;
        }).collect(Collectors.toList());
        remoteStockService.decrStock(bos);

        // 创建订单基本信息
        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        BeanUtils.copyProperties(orderSubmitDTO, orderInfoEntity);
        orderInfoEntity.setUserId(uid);
        orderInfoEntity.setCreateTime(LocalDateTime.now());
        orderInfoEntity.setUpdateTime(LocalDateTime.now());
        orderInfoMapper.insert(orderInfoEntity);
        Long orderId = orderInfoEntity.getOrderId();

        // 创建订单项
        for (OrderSubmitSkuDTO submitSkuDTO : orderSubmitDTO.getSkus()) {
            // 远程调用获得订单项所需的SKU和SPU信息
            OrderSpuBO orderSpuBO = remoteSpuService.getSpuBySkuId(submitSkuDTO.getSkuId());
            // 生成订单项Entity
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderId(orderId);  //设置订单id
            BeanUtils.copyProperties(orderSpuBO, orderItemEntity);  //设置spu部分
            BeanUtils.copyProperties(orderSpuBO.getSkuBO(), orderItemEntity);  //设置sku部分
            orderItemEntity.setSkuPrice(orderSpuBO.getSkuBO().getPrice());  //设置单价
            orderItemEntity.setSkuQuantity(submitSkuDTO.getCount());  //设置数量
            // 计算订单项价格
            orderItemEntity.setRealAmount(orderItemEntity.getSkuPrice().multiply(new BigDecimal(orderItemEntity.getSkuQuantity())));
            orderItemMapper.insert(orderItemEntity);
        }

        // 延时消息：超时取消订单
        OrderCloseBO orderCloseBO = new OrderCloseBO();
        orderCloseBO.setOrderId(orderId);
        orderCloseBO.setUserId(uid);
        Message<OrderCloseBO> closeMsg = MessageBuilder.withPayload(orderCloseBO).build();
        rocketMQTemplate.syncSend("fp-mall-order:close", closeMsg, 3000, 5);

        return orderId;
    }

    @Transactional
    @Override
    public void closeOrder(Long uid, Long orderId) {
        if (orderInfoMapper.getOrderStatusForUpdate(orderId) == OrderStatusConst.WAIT_PAY) {
            orderInfoMapper.updateOrderStatus(uid, orderId, OrderStatusConst.CLOSED);
        }
        log.info("订单并未处于待付款状态, 关闭失败");
    }
}
