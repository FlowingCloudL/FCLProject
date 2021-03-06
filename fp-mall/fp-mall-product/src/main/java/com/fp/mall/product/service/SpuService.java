package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.SpuDTO;
import com.fp.mall.product.model.vo.SpuVO;

import java.util.List;

public interface SpuService {

    /**
     * app端 - 通过商品id列表, 获得商品信息列表
     * @param spuIds 商品id列表
     * @return 商品信息列表
     */
    List<SpuVO> listSpuBySpuIds(List<Long> spuIds);

    /**
     * 获取商品信息
     * @param spuId 商品id
     * @return spuVO
     */
    SpuVO getSpuBySpuId(Long spuId);

    /**
     * 获取 spuId列表
     * @param categoryIds 分类Id列表
     * @param brandId 品牌id
     * @return spuId列表
     */
    List<Long> getSpuIdsByCategoryAndBrand(List<Long> categoryIds, Long brandId);

    /**
     * 保存商品信息, 包括spu和与之关联的基本属性
     * @param spuDTO 商品信息
     */
    void saveSpu(SpuDTO spuDTO);

    /**
     * 更新商品信息, 包括spu和与之关联的基本属性
     * @param spuDTO 商品信息
     */
    void updateSpu(SpuDTO spuDTO);

    /**
     * 批量上架
     * @param spuIds 商品id列表
     */
    void onTheShelf(List<Long> spuIds);

    /**
     * 批量下架
     * @param spuIds 商品id列表
     */
    void offTheShelf(List<Long> spuIds);

    /**
     * 删除商品信息, 包括spu、基本属性、sku、销售属性
     * @param spuId 商品id
     */
    void deleteSpuBySpuId(Long spuId);

    /**
     * 清除商品缓存
     * @param spuId 商品id
     */
    void clearSpuCacheBySpuId(Long spuId);

    /**
     * 批量清除商品缓存
     * @param spuIds 商品id列表
     */
    void batchClearSpuCacheBySpuIds(List<Long> spuIds);

}
