package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.AttrValueEntity;
import com.fp.mall.product.model.entity.SkuSaleAttrEntity;
import com.fp.mall.product.model.entity.SpuBasicAttrEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttrValueMapper {

    /**
     * 通过属性id, 获取属性值id列表
     * @param attrId 属性id
     * @return 属性值id列表
     */
    List<Long> ListIdsByAttrId(@Param("attrId") Long attrId);

    /**
     * 批量保存属性值
     * @param attrValueEntities 属性值列表
     */
    void saveBatch(@Param("attrValues") List<AttrValueEntity> attrValueEntities);

    /**
     * 批量更新属性值
     * @param attrValueEntities 属性值列表
     */
    void updateBatch(@Param("attrValues") List<AttrValueEntity> attrValueEntities);

    /**
     * 批量更新spu的基本属性
     * @param spuBasicAttrEntities 基本属性列表
     */
    void updateBatchOfSpuBasicAttr(@Param("spuBasicAttrValues") List<SpuBasicAttrEntity> spuBasicAttrEntities);

    /**
     * 批量更新sku的销售属性
     * @param skuSaleAttrEntities 销售属性列表
     */
    void updateBatchOfSpuSkuSaleAttr(@Param("SkuSaleAttrValues") List<SkuSaleAttrEntity> skuSaleAttrEntities);

    /**
     * 批量删除
     * @param attrValueIds 属性值id列表
     */
    void deleteBatch(@Param("attrValueIds") List<Long> attrValueIds);
}
