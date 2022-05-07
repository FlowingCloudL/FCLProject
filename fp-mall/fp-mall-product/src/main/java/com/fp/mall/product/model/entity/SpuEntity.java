package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class SpuEntity extends BaseEntity {

    /**
     * 主键 - 商品ID
     */
    private Long spuId;

    /**
     * 商品名称
     */
    private String spuName;

    /**
     * 商品介绍
     */
    private String spuDesc;

    /**
     * 商品介绍主图
     */
    private String descImgUrl;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Byte status;

}
