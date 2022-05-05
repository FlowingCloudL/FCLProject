package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class SkuEntity extends BaseEntity {

    /**
     * 主键 - 库存id
     */
    private Long id;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 多个销售属性值id, 逗号分隔
     */
    private String attrs;

    /**
     * 库存名称
     */
    private String name;

    /**
     * 库存图片
     */
    private String imgUrl;

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
