package com.fp.mall.product.service;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.mall.product.model.dto.BrandDTO;
import com.fp.mall.product.model.vo.BrandVO;

import java.util.List;

public interface BrandService {

    /**
     * 获取品牌信息列表（分页）
     * @param pageDTO 分页参数
     * @param brandDTO 品牌参数
     * @return 品牌信息列表分页数据
     */
    PageVO<BrandVO> listPage(PageDTO pageDTO, BrandDTO brandDTO);

    /**
     * 根据品牌id, 获取品牌信息
     * @param brandId 品牌信息id
     * @return 品牌信息
     */
    BrandVO getByBrandId(Long brandId);

    /**
     * 根据分类id，获取品牌信息列表
     * @param categoryId 分类id
     * @return 品牌信息列表
     */
    List<BrandVO> listByCategoryId(Long categoryId);

    /**
     * 保存品牌信息
     * @param brandDTO 品牌信息
     */
    void save(BrandDTO brandDTO);

    /**
     * 更新品牌信息
     * @param brandDTO 品牌信息
     */
    void update(BrandDTO brandDTO);

    /**
     * 改变品牌状态（启用或禁用）
     * @param brandDTO 品牌参数
     */
    void changeBrandStatus(BrandDTO brandDTO);

    /**
     * 删除品牌信息
     * @param brandId 品牌id
     */
    void deleteByBrandId(Long brandId);

}
