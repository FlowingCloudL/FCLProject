package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.SkuDTO;
import com.fp.mall.product.model.dto.SpuModifyDTO;
import com.fp.mall.product.model.vo.SkuVO;

import java.util.List;

public interface SkuService {

    /**
     * 获取 sku信息
     * @param skuId skuId
     * @return sku信息
     */
    SkuVO getSkuBySkuId(Long skuId);

    /**
     * 获取 sku列表（会被缓存）
     * @param spuId 商品id
     * @return sku列表
     */
    List<SkuVO> listSkuBySpuId(Long spuId);

    /**
     * 保存 sku信息
     * @param spu 商品id
     * @param skuList SKU列表
     */
    void saveSku(Long spu, List<SkuDTO> skuList);

    /**
     * 更新 sku信息 (通过spuId去数据库同样查出skuList, 筛选出分别要更新/插入/删除)
     * @param spuId 商品id
     * @param skuList SKU列表
     */
    void updateSku(Long spuId, List<SkuDTO> skuList);

    /**
     * 更新sku金额或者库存信息
     * @param skuList SKU列表
     */
    void updateSkuPriceAndStock(List<SkuDTO> skuList);

    /**
     * 删除 sku信息
     * @param skuId SKU id
     */
    void deleteSkuBySkuId(Long skuId);

    /**
     * 删除 sku信息
     * @param spuId 商品id
     */
    void deleteSkuBySpuId(Long spuId);

    /**
     * 清除 sku缓存
     * @param spuId 商品id
     * @param skuIds skuId列表
     */
    void clearSkuCacheBySpuIdOrSkuIds(Long spuId, List<Long> skuIds);


    /**
     * 获取商品的sku列表（仅获取启用状态）
     * @param spuId
     * @return
     */
//    List<SkuAppVO> getSkuBySpuId(Long spuId);

}
