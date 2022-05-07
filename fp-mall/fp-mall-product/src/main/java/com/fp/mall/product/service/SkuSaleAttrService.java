package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.SkuSaleAttrDTO;
import com.fp.mall.product.model.vo.SkuSaleAttrVO;

import java.util.List;

public interface SkuSaleAttrService {

    /**
     * 根据spuId, 获取销售属性列表
     * @param skuId SKU ID
     * @return 商品基本属性列表
     */
    List<SkuSaleAttrVO> listBySkuId(Long skuId);

    /**
     * 根据属性id, 获取销售属性列表
     * @param attrId 属性id
     * @return 商品基本属性列表
     */
    List<SkuSaleAttrVO> listByAttrId(Long attrId);

    /**
     * 批量保存 销售属性
     * @param skuId 库存id
     * @param skuSaleAttrDTOList 销售属性列表
     */
    void saveBatch(Long skuId, List<SkuSaleAttrDTO> skuSaleAttrDTOList);

    /**
     * 批量更新 销售属性
     * @param skuId 库存id
     * @param skuSaleAttrDTOList 销售属性列表
     */
    void updateBatch(Long skuId, List<SkuSaleAttrDTO> skuSaleAttrDTOList);

    /**
     * 根据销售属性id, 删除销售属性
     * @param id 销售属性id
     */
    void deleteById(Long id);

    /**
     * 根据skuId, 删除销售属性
     * @param skuId 库存id
     */
    void deleteBySkuId(Long skuId);

    /**
     * 根据skuId, 删除销售属性
     * @param spuId 商品id
     */
    void deleteBySpuId(Long spuId);

}
