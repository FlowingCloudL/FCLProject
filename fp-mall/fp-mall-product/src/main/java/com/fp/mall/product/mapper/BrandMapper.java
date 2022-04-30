package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.BrandDTO;
import com.fp.mall.product.model.entity.BrandEntity;
import com.fp.mall.product.model.vo.BrandVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

    /**
     * 获取品牌信息列表
     * @param brandDTO 品牌参数
     * @return 品牌信息列表
     */
    List<BrandVO> list(@Param("brandDTO") BrandDTO brandDTO);

    /**
     * 根据品牌信息id获取品牌信息
     * @param brandId 品牌信息id
     * @return 品牌信息
     */
    BrandVO getByBrandId(@Param("brandId") Long brandId);

    /**
     * 根据分类id，获取品牌列表
     * @param categoryId 分类id
     * @return 品牌VO列表
     */
    List<BrandVO> listByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 获取品牌在商品中使用的数量
     * @param brandId 品牌id
     * @return 使用该品牌的商品数量
     */
    Long countUseInSpu(@Param("brandId") Long brandId);

    /**
     * 保存品牌信息
     * @param brandEntity 品牌实体类
     */
    void save(@Param("brand") BrandEntity brandEntity);

    /**
     * 更新品牌信息
     * @param brandEntity 品牌实体类
     */
    void update(@Param("brand") BrandEntity brandEntity);

    /**
     * 根据品牌id, 删除品牌信息
     * @param brandId 品牌id
     */
    void deleteById(@Param("brandId") Long brandId);

}
