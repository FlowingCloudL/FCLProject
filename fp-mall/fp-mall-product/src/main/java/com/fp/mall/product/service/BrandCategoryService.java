package com.fp.mall.product.service;

import java.util.List;

public interface BrandCategoryService {

    /**
     * 通过品牌id, 获取关联的分类id列表
     * @param brandId 品牌id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByBrandId(Long brandId);

    /**
     * 通过分类id, 获取关联的品牌id列表
     * @param categoryId 分类id
     * @return 品牌id列表
     */
    List<Long> listBrandIdsByCategoryId(Long categoryId);

    /**
     * 保存关联: 品牌id -> 分类id列表
     * @param brandId 品牌id
     * @param categoryIds 分类id列表
     */
    void saveBrandToCategory(Long brandId, List<Long> categoryIds);

    /**
     * 更新关联: 品牌id -> 分类id列表
     * @param brandId 品牌id
     * @param categoryIds 分类id列表
     */
    void updateBrandToCategory(Long brandId, List<Long> categoryIds);

    /**
     * 删除该品牌的关联
     * @param brandId 品牌id
     */
    void deleteByBrandId(Long brandId);

    /**
     * 删除关联: 品牌id -> 分类ids
     * @param brandId 品牌id
     * @param categoryIds 分类id列表
     */
    void deleteBrandToCategory(Long brandId, List<Long> categoryIds);

    /**
     * 删除关联: 分类id -> 品牌ids
     * @param categoryId 分类id
     * @param brandIds 品牌id列表
     */
    void deleteCategoryToBrand(Long categoryId, List<Long> brandIds);
}
