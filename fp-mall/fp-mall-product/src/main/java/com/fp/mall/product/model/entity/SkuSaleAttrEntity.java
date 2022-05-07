package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class SkuSaleAttrEntity extends BaseEntity {

    /**
     * 关联信息id
     */
    private Long id;

    /**
     * SKU ID
     */
    private Long skuId;

    /**
     * 销售属性ID
     */
    private Long attrId;

    /**
     * 销售属性名称
     */
    private String attrName;

    /**
     * 销售属性值
     */
    private String attrValue;

}
