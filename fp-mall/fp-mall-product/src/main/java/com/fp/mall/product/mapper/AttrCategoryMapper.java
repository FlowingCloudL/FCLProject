package com.fp.mall.product.mapper;

import com.fp.mall.product.model.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttrCategoryMapper {


    /**
     * 通过属性id，获取关联的分类id列表
     * @param attrId 属性id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByAttrId(@Param("attrId") Long attrId);

    /**
     * 批量保存属性与分类的关联信息
     * @param attrId 属性id
     * @param categoryIds 分类id列表
     */
    void saveBatch(@Param("attrId") Long attrId, @Param("categoryIds") List<Long> categoryIds);

    /**
     * 批量删除属性与分类的关联信息
     * @param attrId 属性id
     * @param categoryIds 分类id列表
     */
    void deleteBatch(@Param("attrId") Long attrId, @Param("categoryIds") List<Long> categoryIds);

}
