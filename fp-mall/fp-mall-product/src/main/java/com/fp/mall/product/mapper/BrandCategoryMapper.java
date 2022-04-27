package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.BrandCategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandCategoryMapper {

    /**
     * 根据品牌id, 获取关联的分类id
     * @param brandId 品牌id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByBrandId(@Param("brandId") Long brandId);

    /**
     * 批量保存关联信息
     * @param brandCategoryEntityList 品牌-分类 关联项列表
     */
    void saveBatch(@Param("brandCategoryList") List<BrandCategoryEntity> brandCategoryEntityList);

    /**
     * 根据品牌id, 删除该品牌id下的所有关联信息
     * @param brandId 品牌id
     */
    void deleteByBrandId(@Param("brandId") Long brandId);

    /**
     * 根据品牌id和分类id列表, 删除该品牌id下的与指定分类的关联信息
     * @param brandId 品牌id
     * @param categoryIds 要删除的关联分类的分类id列表
     */
    void deleteByBrandIdAndCategoryIds(@Param("brandId") Long brandId, @Param("categoryIds") List<Long> categoryIds);

}
