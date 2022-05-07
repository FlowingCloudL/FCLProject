package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.SpuBasicAttrDTO;
import com.fp.mall.product.model.vo.SpuBasicAttrVO;

import java.util.List;

public interface SpuBasicAttrService {

    /**
     * 根据spuId, 获取商品基本属性列表
     * @param spuId 商品id
     * @return 商品基本属性列表
     */
    List<SpuBasicAttrVO> listBySpuId(Long spuId);

    /**
     * 根据属性id, 获取商品基本属性列表
     * @param attrId 属性id
     * @return 商品基本属性列表
     */
    List<SpuBasicAttrVO> listByAttrId(Long attrId);

    /**
     * 批量保存 商品基本属性
     * @param spuId 商品id
     * @param dtoList 基本属性信息列表
     */
    void saveBatch(Long spuId, List<SpuBasicAttrDTO> dtoList);

    /**
     * 批量更新 商品基本属性
     * @param spuId 商品id
     * @param dtoList 商品基本属性列表
     */
    void updateBatch(Long spuId, List<SpuBasicAttrDTO> dtoList);

    /**
     * 根据商品id, 删除基本属性
     * @param spuId 商品id
     */
    void deleteBySpuId(Long spuId);

    /**
     * 根据基本属性id, 删除基本属性
     * @param attrId 基本属性id
     */
    void deleteByAttrId(Long attrId);

}
