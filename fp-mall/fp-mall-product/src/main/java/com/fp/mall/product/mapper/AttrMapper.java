package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttrMapper {

    /**
     * 根据分类id，获取属性信息列表 (还包括分类id为0的属性, 即未分类属性)
     * @param categoryId 分类id
     * @return 属性信息列表
     */
    List<AttrEntity> listByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 根据属性id, 获取属性id信息
     * @param attrId 属性id
     * @return 属性信息
     */
    AttrEntity getByAttrId(@Param("attrId") Long attrId);

    /**
     * 保存属性信息
     * @param attr 属性信息
     */
    void save(@Param("attr") AttrEntity attr);

    /**
     * 更新属性信息
     * @param attr 属性信息
     */
    void update(@Param("attr") AttrEntity attr);

    /**
     * 根据属性id, 删除属性信息
     * @param attrId 属性id
     */
    void deleteByAttrId(@Param("attrId") Long attrId);

}
