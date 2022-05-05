package com.fp.mall.product.service;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.mall.product.model.dto.SpuDTO;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.vo.SpuVO;

import java.util.List;

public interface SpuService {

    /**
     * 分页获取商品信息列表
     * @param spuSearchDTO 商品搜索参数
     * @param pageDTO 分页参数
     * @return spuVO列表(分页数据)
     */
    PageVO<SpuVO> searchSpuByPage(SpuSearchDTO spuSearchDTO, PageDTO pageDTO);

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
     * 保存商品信息
     * @param spuDTO 商品信息
     */
    void saveSpu(SpuDTO spuDTO);

    /**
     * 更新商品信息
     * @param spuDTO 商品信息
     */
    void updateSpu(SpuDTO spuDTO);

    /**
     * 删除商品信息
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

    /**
     * 改变商品状态（上下架）
     * @param spuId 商品id
     * @param status 商品状态
     */
    void changeSpuStatus(Long spuId, Short status);

    /**
     * 更新商品的信息
     * @param spuModifyDTO
     */
//    void updateSpuOrSku(SpuModifyDTO spuModifyDTO);

    /**
     * 更新spu表（canal监听后，会发送更新的消息，更新es中的数据）
     * @param spuIds
     * @param categoryIds
     */
//    void updateSpuUpdateTime(List<Long> spuIds, List<Long> categoryIds);

    /**
     * 根据分组id和是否为当前分组，返回商品列表
     * @param pageDTO 分页信息
     * @param spuDTO 分组信息
     * @param isContain 是否当前分组商品 1.参与 0.不参与
     * @return 商品列表
     */
//    PageVO<SpuVO> pageByLangAndTagId(PageDTO pageDTO, SpuDTO spuDTO, Integer isContain);

}
