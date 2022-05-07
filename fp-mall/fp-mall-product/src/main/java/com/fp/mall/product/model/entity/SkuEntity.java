package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class SkuEntity extends BaseEntity {

    /**
     * 主键 - 库存id
     */
    private Long skuId;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 库存名称
     */
    private String skuName;

    /**
     * 库存介绍
     */
    private String skuDesc;

    /**
     * 售价，整数方式保存
     */
    private Long price;

    /**
     * 库存数量
     */
    private Long stock;

    /**
     * 销量
     */
    private Long sales;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Byte status;

}
