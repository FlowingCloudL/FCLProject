package com.fp.mall.product.service;

import java.util.List;

public interface BrandCategoryService {

    /**
     * 通过品牌id, 获取关联的分类id列表
     * @param brandId 品牌id
     * @return 分类id列表
     */
    List<Long> getCategoryIdsByBrandId(Long brandId);

    /**
     * 通过分类id, 获取关联的品牌id列表
     * @param categoryId 分类id
     * @return 品牌id列表
     */
    List<Long> getBrandIdsByCategoryId(Long categoryId);

    /**
     * 关联: 品牌id -> 分类id列表
     * @param brandId 品牌id
     * @param categoryIds 分类id列表
     */
    void saveBrandToCategory(Long brandId, List<Long> categoryIds);

    /**
     * 更新: 品牌id -> 分类id列表
     * @param brandId 品牌id
     * @param categoryIds 分类id列表
     */
    void updateBrandToCategory(Long brandId, List<Long> categoryIds);

    /**
     * 删除: 品牌id -> 分类id
     * @param brandId 品牌id
     */
    void deleteBrandToCategory(Long brandId);
}
