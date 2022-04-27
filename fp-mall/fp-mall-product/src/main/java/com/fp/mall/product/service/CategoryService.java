package com.fp.mall.product.service;

import com.fp.mall.product.model.entity.CategoryEntity;
import com.fp.mall.product.model.vo.CategoryVO;

import java.util.List;

/**
 * 分类业务
 */
public interface CategoryService {

    /**
     * 获取0级分类VO列表
     * @return 分类VO列表
     */
    List<CategoryVO> listCategories();

    /**
     * 根据父分类id获取分类VO列表
     * @param parentId 父分类id
     * @return 分类VO列表
     */
    List<CategoryVO> listCategoriesByParentId(Long parentId);

    /**
     * 根据父分类id获取分类id列表
     * @param parentId 父分类id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByParentId(Long parentId);

    /**
     * 根据分类id获取分类列表
     * @param id 分类id
     * @return 分类VO
     */
    CategoryVO getCategoryByCategoryId(Long id);

    /**
     * 保存分类信息
     * @param category 分类实体
     */
    void save(CategoryEntity category);

    /**
     * 更新分类信息
     * @param category 分类实体
     */
    void update(CategoryEntity category);

    /**
     * 根据分类id删除分类信息
     * @param id 分类id
     */
    void deleteByCategoryId(Long id);




}
