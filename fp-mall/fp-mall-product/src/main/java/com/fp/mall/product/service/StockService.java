package com.fp.mall.product.service;


public interface StockService {

    /**
     * 减库存, 采用方法: SQL直接更新
     * @param skuId SKU编号
     * @param count 数量
     * @return 更新行数
     */
    int reduceDirectly(Long skuId, Integer count);

}
