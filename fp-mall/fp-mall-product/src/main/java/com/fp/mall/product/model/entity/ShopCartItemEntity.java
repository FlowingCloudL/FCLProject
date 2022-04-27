package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class ShopCartItemEntity extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 产品ID
     */
    private Long spuId;

    /**
     * 库存ID
     */
    private Long skuId;

    /**
     * 商品个数
     */
    private Integer count;

    /**
     * 是否勾选
     */
    private Byte Checked;

}
