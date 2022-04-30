package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.CategoryEntity;
import com.fp.mall.product.model.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    /**
     * 根据分类id, 获取分类VO (不嵌套子分类)
     * @param categoryId 分类id
     * @return 分类VO
     */
    CategoryVO getCategoryVOByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 获取分类VO列表 (不嵌套子分类)
     * @param parentId 父分类id
     * @param status 状态
     * @return 分类VO列表
     */
    List<CategoryVO> listCategoryVOByParentIdAndStatus(@Param("parentId") Long parentId, @Param("status") Byte status);

    /**
     * 获取分类VO列表 (嵌套子分类)
     * @return 分类VO列表
     */
    List<CategoryVO> listCategoryVOAndChild();

    /**
     * 根据父分类id 获取子分类实体
     * @param parentId 父分类id
     * @return 分类实体
     */
    List<CategoryEntity> listCategoryEntityByParentId(@Param("parentId") Long parentId);

    /**
     * 根据分类id列表，获取分类实体列表
     * @param categoryIds 分类id列表
     * @return 分类实体列表
     */
    List<CategoryEntity> listCategoryEntityByCategoryIds(@Param("categoryIds") List<Long> categoryIds);

    /**
     * 获取子分类id列表
     * @param parentId 父分类id
     * @return 子分类id列表
     */
    List<Long> listCategoryIdByParentId(@Param("parentId") Long parentId);

    /**
     * 保存分类信息
     * @param categoryEntity 分类实体
     */
    void save(@Param("category") CategoryEntity categoryEntity);

    /**
     * 更新分类信息
     * @param categoryEntity 分类实体
     * @return 更新的数量
     */
    int update(@Param("category") CategoryEntity categoryEntity);

    /**
     * 批量更新分类状态（启用、禁用）
     * @param categoryIds 分类id列表
     * @param status 目标状态
     */
    void changeBatchOfStatus(@Param("categoryIds") List<Long> categoryIds, @Param("status") Integer status);

    /**
     * 删除分类信息
     * @param categoryId 分类id
     */
    void deleteById(@Param("categoryId") Long categoryId);





}
