package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.BrandDTO;
import com.fp.mall.product.model.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {

    /**
     * 获取品牌信息列表
     * @param brandDTO 品牌参数
     * @return 品牌信息列表
     */
    List<BrandEntity> list(@Param("brandDTO") BrandDTO brandDTO);

    /**
     * 根据品牌id列表, 获取品牌列表
     * @param ids 品牌id列表
     * @return 品牌信息列表
     */
    List<BrandEntity> listByIds(@Param("ids") List<Long> ids);

    /**
     * 根据品牌id, 获取品牌信息
     * @param id 品牌id
     * @return 品牌信息
     */
    BrandEntity getById(@Param("id") Long id);

    /**
     * 获取品牌在商品中使用的数量
     * @param brandId 品牌id
     * @return 使用该品牌的商品数量
     */
    Long countUseInSpu(@Param("brandId") Long brandId);

    /**
     * 保存品牌信息
     * @param brandEntity 品牌实体类
     * @return 品牌id
     */
    Long save(@Param("brand") BrandEntity brandEntity);

    /**
     * 更新品牌信息
     * @param brandEntity 品牌实体类
     */
    void update(@Param("brand") BrandEntity brandEntity);

    /**
     * 更新品牌状态 (禁用/启用)
     * @param brandId 品牌id
     * @param status 状态
     */
    void changeStatus(@Param("brandId") Long brandId, @Param("status") Byte status);

    /**
     * 根据品牌id, 删除品牌信息
     * @param id 品牌id
     */
    void deleteById(@Param("id") Long id);

}
