package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.AttrValueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttrValueMapper {

    /**
     * 通过属性id, 获取属性值id列表
     * @param attrId 属性id
     * @return 属性值id列表
     */
    List<Long> listAttrValueIdsByAttrId(@Param("attrId") Long attrId);

    /**
     * 批量保存属性值
     * @param attrValueEntityList 属性值列表
     */
    void saveBatch(@Param("attrValueEntityList") List<AttrValueEntity> attrValueEntityList);

    /**
     * 批量更新属性值
     * @param attrValueEntityList 属性值列表
     */
    void updateBatch(@Param("attrValueEntityList") List<AttrValueEntity> attrValueEntityList);

    /**
     * 批量删除
     * @param attrValueIdList 属性值id列表
     */
    void deleteBatch(@Param("attrValueIdList") List<Long> attrValueIdList);
}
