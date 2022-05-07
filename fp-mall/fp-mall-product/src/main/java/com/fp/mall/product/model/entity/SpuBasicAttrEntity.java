package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class SpuBasicAttrEntity extends BaseEntity {

    /**
     * 关联信息id
     */
    private Long id;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 规格属性id
     */
    private Long attrId;

    /**
     * 规格属性名称
     */
    private String attrName;

    /**
     * 规格属性值
     */
    private String attrValue;

}
