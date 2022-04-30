package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.SpuBasicAttrEntity;
import com.fp.mall.product.model.vo.SpuBasicAttrVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuBasicAttrMapper {

    /**
     * 根据商品id, 获取商品的基本属性列表
     * @param spuId 商品id
     * @return 基本属性列表
     */
    List<SpuBasicAttrVO> listSpuBasicAttrsBySpuId(@Param("spuId") Long spuId);

    /**
     * 根据基本属性值id列表, 获取商品Id列表
     * @param attrValueIds 属性值id列表
     * @return 商品id列表
     */
    List<Long> listSpuIdsByAttrValueIds(@Param("attrValueIds") List<Long> attrValueIds);

    /**
     * 保存 商品与基本属性的关联信息
     * @param spuBasicAttrEntity 商品与基本属性的关联信息
     */
    void save(@Param("entity") SpuBasicAttrEntity spuBasicAttrEntity);

    /**
     * 批量保存 商品与基本属性的关联信息
     * @param spuBasicAttrEntityList 商品与基本属性的关联信息 列表
     */
    void saveBatch(@Param("entityList") List<SpuBasicAttrEntity> spuBasicAttrEntityList);

    /**
     * 批量更新属性信息 (用于属性表和属性值表更新时，进行同步更新)
     * @param attrId 属性id
     * @param attrName 属性名称
     */
    void updateAttr(@Param("attrId") Long attrId, @Param("attrName") String attrName);

    /**
     * 批量更新属性值信息 (用于属性表和属性值表更新时，进行同步更新)
     * @param attrValueId 属性id
     * @param attrValue 属性名称
     */
    void updateAttrValue(@Param("attrValueId") Long attrValueId, @Param("attrValue") String attrValue);

    /**
     * 根据商品id, 删除对应关联
     * @param spuId 商品id
     */
    void deleteBySpuId(@Param("spuId") Long spuId);

    /**
     * 通过关联表id, 批量删除关联
     * @param idList 关联表id列表
     */
    void deleteBatchById(@Param("idList") List<Long> idList);

    /**
     * 根据属性id和属性值id列表, 删除关联
     * @param attrId 属性id
     * @param attrValueIds 属性值id列表 (可选, 限定属性id下的哪些属性值可以删除)
     */
    void deleteByAttIdAndAttrValueIds(@Param("attrId") Long attrId, @Param("attrValueIds") List<Long> attrValueIds);

}
