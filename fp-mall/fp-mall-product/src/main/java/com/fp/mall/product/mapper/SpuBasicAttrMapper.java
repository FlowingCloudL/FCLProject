package com.fp.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.product.model.entity.SpuBasicAttrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuBasicAttrMapper {

    /**
     * 根据商品id, 获取商品的基本属性值列表
     * @param spuId 商品id
     * @return 基本属性值列表
     */
    List<SpuBasicAttrEntity> listBySpuId(@Param("spuId") Long spuId);

    /**
     * 根据属性id, 获取商品的基本属性值列表
     * @param attrId 基本属性id
     * @return 基本属性值列表
     */
    List<SpuBasicAttrEntity> listByAttrId(@Param("attrId") Long attrId);

    /**
     * 批量保存 商品的基本属性信息
     * @param spuId 商品id
     * @param spuBasicAttrEntityList 商品的基本属性信息 列表
     */
    void saveBatch(@Param("spuId") Long spuId, @Param("entityList") List<SpuBasicAttrEntity> spuBasicAttrEntityList);

    /**
     * 批量更新属性信息
     * @param spuId 商品id
     * @param spuBasicAttrEntityList 基本属性信息 列表
     */
    void updateBatch(@Param("spuId") Long spuId, @Param("entityList") List<SpuBasicAttrEntity> spuBasicAttrEntityList);

    /**
     * 通过基本属性id, 删除基本属性信息
     * @param id 基本属性id
     */
    void deleteById(@Param("id") Long id );

    /**
     * 根据商品id, 删除基本属性信息
     * @param spuId 商品id
     */
    void deleteBySpuId(@Param("spuId") Long spuId);

    /**
     * 根据属性id, 删除基本属性信息
     * @param attrId 属性id
     */
    void deleteByAttrId(@Param("attrId") Long attrId);

}
