package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.BrandCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandCategoryMapper {

    /**
     * 根据品牌id, 获取关联的分类id
     * @param brandId 品牌id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByBrandId(@Param("brandId") Long brandId);

    /**
     * 根据分类id, 获取关联的品牌id
     * @param categoryId 分类id
     * @return 品牌id列表
     */
    List<Long> listBrandIdsByCategoryId(@Param("categoryId") Long categoryId);

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
     * 根据分类id, 删除该分类下的所有关联信息
     * @param categoryId 分类id
     */
    void deleteByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 根据品牌id和分类id列表, 删除该品牌下的与指定分类的关联信息
     * @param brandId 品牌id
     * @param categoryIds 分类id列表
     */
    void deleteBrandIdToCategoryIds(@Param("brandId") Long brandId, @Param("categoryIds") List<Long> categoryIds);

    /**
     * 根据分类id和品牌id列表, 删除该分类与指定品牌的关联信息
     * @param categoryId 分类id
     * @param brandIds 品牌id列表
     */
    void deleteCategoryIdToBrandIds(@Param("categoryId") Long categoryId, @Param("brandIds") List<Long> brandIds);

}
