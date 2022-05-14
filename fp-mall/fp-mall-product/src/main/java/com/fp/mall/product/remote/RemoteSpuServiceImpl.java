package com.fp.mall.product.remote;

import com.fp.api.mall.product.model.OrderSkuBO;
import com.fp.api.mall.product.model.OrderSpuBO;
import com.fp.api.mall.product.service.RemoteSpuService;
import com.fp.mall.product.mapper.SkuMapper;
import com.fp.mall.product.mapper.SpuMapper;
import com.fp.mall.product.model.entity.SkuEntity;
import com.fp.mall.product.model.entity.SpuEntity;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@DubboService
public class RemoteSpuServiceImpl implements RemoteSpuService {

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private SkuMapper skuMapper;

    @Transactional
    @Override
    public OrderSpuBO getSpuBySkuId(Long skuId) {
        // 获取SKU
        SkuEntity skuEntity = skuMapper.getBySkuId(skuId);
        OrderSkuBO orderSkuBO = new OrderSkuBO();
        BeanUtils.copyProperties(skuEntity, orderSkuBO);
        // 获取SPU
        SpuEntity spuEntity = spuMapper.getBySpuId(skuEntity.getSpuId());
        OrderSpuBO orderSpuBO = new OrderSpuBO();
        BeanUtils.copyProperties(spuEntity, orderSpuBO);
        // 设置SKU到SPU
        orderSpuBO.setSkuBO(orderSkuBO);
        return orderSpuBO;
    }

}
