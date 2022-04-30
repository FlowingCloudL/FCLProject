package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.SkuSaleAttrEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuSaleAttrMapper {

    /**
     * 保存 sku与销售属性的关联信息
     * @param skuSaleAttrEntity sku与销售属性的关联信息
     */
    void save(@Param("skuSaleAttr") SkuSaleAttrEntity skuSaleAttrEntity);

    /**
     * 批量 sku与销售属性的关联信息
     * @param skuSaleAttrEntityList sku与销售属性的关联信息 列表
     */
    void saveBatch(@Param("skuSaleAttrList") List<SkuSaleAttrEntity> skuSaleAttrEntityList);

    /**
     * 更新 sku与销售属性的关联信息
     * @param skuSaleAttrEntity sku与销售属性的关联信息
     */
    void update(@Param("skuSaleAttr") SkuSaleAttrEntity skuSaleAttrEntity);

    /**
     * 批量更新 sku与销售属性的关联信息
     * @param skuSaleAttrEntityList sku与销售属性的关联信息 列表
     */
    void updateBatch(@Param("skuSaleAttrList") List<SkuSaleAttrEntity> skuSaleAttrEntityList);

    /**
     * 通过商品id, 改变关联项的状态
     * @param spuId 商品id
     * @param status 目标状态
     */
    void changeStatusBySpuId(@Param("spuId") Long spuId, @Param("status") Byte status);

    /**
     * 通过skuId列表, 批量改变关联项的状态
     * @param skuIds skuId列表
     * @param status 目标状态
     */
    void changeStatusBySkuIds(@Param("skuIds") List<Long> skuIds, @Param("status") Byte status);

    /**
     * 根据关联id, 删除关联信息
     * @param id 关联表id
     */
    void deleteById(@Param("id") Long id);

}
