package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.StockMapper;
import com.fp.mall.product.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public int reduceDirectly(Long skuId, Integer count) {
        return stockMapper.reduceStock(skuId, count);
    }
}
