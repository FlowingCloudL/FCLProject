package com.fp.mall.product.service;

import com.fp.mall.product.model.entity.SpuBasicAttrEntity;
import com.fp.mall.product.model.vo.SpuBasicAttrVO;

import java.util.List;

public interface SpuBasicAttrService {

    /**
     * 根据spuId, 获取商品基本属性列表
     * @param spuId 商品id
     * @return 商品基本属性列表
     */
    List<SpuBasicAttrVO> listBySpuId(Long spuId);

    /**
     * 批量保存
     * @param spuId 商品id
     * @param spuBasicAttrEntities 基本属性信息列表
     */
    void saveBatch(Long spuId, List<SpuBasicAttrEntity> spuBasicAttrEntities);

    /**
     * 批量更新商品基本属性
     * @param spuBasicAttrEntities 商品基本属性列表
     */
    void updateBatch(List<SpuBasicAttrEntity> spuBasicAttrEntities);

    /**
     * 更新商品与基本属性的关联信息
     * @param spuId 商品id
     * @param spuBasicAttrEntities 商品基本属性列表
     * @param spuAttrValuesDb 缓存中的商品属性信息
     */
    void updateRelation(Long spuId, List<SpuBasicAttrEntity> spuBasicAttrEntities, List<SpuBasicAttrVO> spuAttrValuesDb);

    /**
     * 根据商品id, 删除基本属性
     * @param spuId 商品id
     */
    void deleteBySpuId(Long spuId);

    /**
     * 根据属性id合和属性值id列表, 删除商品与基本属性的关联信息, 并发送消息到队列
     * @param attrId 属性id列表
     * @param attrValueId 属性值id列表
     */
    void deleteBatch(List<Long> attrId, List<Long> attrValueId);

}
