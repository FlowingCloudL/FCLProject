package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.SkuDTO;
import com.fp.mall.product.model.vo.SkuVO;

import java.util.List;

public interface SkuService {

    /**
     * 获取 sku信息
     * @param skuId skuId
     * @return sku信息
     */
    SkuVO getBySkuId(Long skuId);

    /**
     * 获取 sku列表（会被缓存）
     * @param spuId 商品id
     * @return sku列表
     */
    List<SkuVO> listBySpuId(Long spuId);

    /**
     * 保存 sku信息, 包括sku和销售属性
     * @param skuDTO SKU信息
     */
    void save(SkuDTO skuDTO);

    /**
     * 更新 sku信息, 包括sku和销售属性
     * @param skuDTO SKU信息
     */
    void update(SkuDTO skuDTO);

    /**
     * 批量改变库存状态
     * @param skuIds 库存id列表
     * @param status 目标状态
     */
    void changeStatus(List<Long> skuIds, Byte status);

    /**
     * 删除 sku信息, 包括sku和销售属性
     * @param skuId SKU id
     */
    void deleteBySkuId(Long skuId);

    /**
     * 删除 sku信息, 包括sku和销售属性
     * @param spuId 商品id
     */
    void deleteBySpuId(Long spuId);

    /**
     * 清除 sku缓存, 包括sku和销售属性
     * @param spuId 商品id
     * @param skuIds skuId列表
     */
    void clearSkuCacheBySpuIdOrSkuIds(Long spuId, List<Long> skuIds);

}
