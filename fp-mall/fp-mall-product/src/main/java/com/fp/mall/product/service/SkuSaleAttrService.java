package com.fp.mall.product.service;

import com.fp.mall.product.model.entity.SkuSaleAttrEntity;

import java.util.List;

public interface SkuSaleAttrService {

    /**
     * 保存销售属性与sku的关联信息
     * @param skuSaleAttrEntity 关联信息
     */
    void save(SkuSaleAttrEntity skuSaleAttrEntity);

    /**
     * 批量保存关联信息
     * @param skuSaleAttrEntities 关联信息列表
     */
    void saveBatch(List<SkuSaleAttrEntity> skuSaleAttrEntities);

    /**
     * 根据skuId列表, 改变销售属性的状态
     * @param skuIds skuId列表
     * @param status 状态
     */
    void changeStatusBySkuIds(List<Long> skuIds, Byte status);

    /**
     * 根据spuId, 改变销售属性的状态
     * @param spuId spuId
     * @param status 状态
     */
    void changeStatusBySpuId(Long spuId, Byte status);

    /**
     * 批量更新商品sku销售属性关联信息
     * @param spuSkuAttrValues sku与销售属性的关联信息
     */
    void updateBatch(List<SkuSaleAttrEntity> spuSkuAttrValues);

    /**
     * 根据关联id, 删除关联信息
     * @param id 关联id
     */
    void deleteById(Long id);





}
