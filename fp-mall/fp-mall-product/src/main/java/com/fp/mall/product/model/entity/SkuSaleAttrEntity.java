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
     * SPU ID
     */
    private Long spuId;

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
     * 销售属性值ID
     */
    private Long attrValueId;

    /**
     * 销售属性值
     */
    private String attrValue;

    /**
     * 状态 | 0:disable, 1:enable
     */
    private Byte status;
}
