package com.fp.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.product.model.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 根据分类id, 获取分类信息
     * @param categoryId 分类id
     * @return 分类信息
     */
    CategoryEntity getByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 根据分类id列表，获取分类信息列表
     * @param categoryIds 分类id列表
     * @return 分类信息列表
     */
    List<CategoryEntity> listByCategoryIds(@Param("categoryIds") List<Long> categoryIds);

    /**
     * 根据父分类id 获取分类信息列表
     * @param parentId 父分类id
     * @return 分类信息列表
     */
    List<CategoryEntity> listByParentId(@Param("parentId") Long parentId);

    /**
     * 通过父id和status, 获取分类信息列表
     * @param parentId 父分类id
     * @param status 状态
     * @return 分类信息列表
     */
    List<CategoryEntity> listByParentIdAndStatus(@Param("parentId") Long parentId, @Param("status") Byte status);

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
    void deleteByCategoryId(@Param("categoryId") Long categoryId);





}
