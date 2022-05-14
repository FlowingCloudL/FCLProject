package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.CategoryDTO;
import com.fp.mall.product.model.vo.CategoryVO;

import java.util.List;

/**
 * 分类业务
 */
public interface CategoryService {

    /**
     * 获取全部分类VO, 嵌套为菜单
     * @return 0级分类VO列表, 内部嵌套子分类
     */
    List<CategoryVO> listCategories();

    /**
     * 根据父分类id, 获取分类VO列表
     * @param parentId 父分类id
     * @return 分类VO列表
     */
    List<CategoryVO> listCategoriesByParentId(Long parentId);

    /**
     * 根据父分类id, 获取分类id列表
     * @param parentId 父分类id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByParentId(Long parentId);

    /**
     * 根据分类id列表, 获取分类VO列表
     * @param categoryIds 分类id列表
     * @return 分类VO列表
     */
    List<CategoryVO> listCategoriesByCategoryIds(List<Long> categoryIds);

    /**
     * 根据分类id获取分类VO
     * @param categoryId 分类id
     * @return 分类VO
     */
    CategoryVO getCategoryByCategoryId(Long categoryId);

    /**
     * 保存分类信息
     * @param categoryDTO 分类DTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 更新分类信息
     * @param categoryDTO 分类DTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 根据分类id删除分类信息
     * @param id 分类id
     */
    void deleteByCategoryId(Long id);




}
