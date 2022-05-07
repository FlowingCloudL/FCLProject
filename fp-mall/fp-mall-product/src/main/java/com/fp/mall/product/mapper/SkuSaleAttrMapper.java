package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.SkuSaleAttrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuSaleAttrMapper {

    /**
     * 通过skuId, 获取销售属性列表
     * @param skuId skuId
     * @return 销售属性列表
     */
    List<SkuSaleAttrEntity> listBySkuId(@Param("skuId") Long skuId);

    /**
     * 批量保存 sku的销售属性
     * @param skuId 库存id
     * @param skuSaleAttrEntityList sku的销售属性信息 列表
     */
    void saveBatch(@Param("skuId") Long skuId, @Param("skuSaleAttrList") List<SkuSaleAttrEntity> skuSaleAttrEntityList);

    /**
     * 批量更新 sku的销售属性
     * @param skuId 库存id
     * @param skuSaleAttrEntityList sku的销售属性信息 列表
     */
    void updateBatch(@Param("skuId") Long skuId, @Param("skuSaleAttrList") List<SkuSaleAttrEntity> skuSaleAttrEntityList);

    /**
     * 根据销售属性id, 删除销售属性
     * @param id 销售属性id
     */
    void deleteById(@Param("id") Long id);

    /**
     * 通过库存id, 删除销售属性
     * @param skuId SKU ID
     */
    void deleteBySkuId(@Param("skuId") Long skuId);

    /**
     * 通过商品id, 删除销售属性
     * @param spuId 商品id
     */
    void deleteBySpuId(@Param("spuId") Long spuId);

}
