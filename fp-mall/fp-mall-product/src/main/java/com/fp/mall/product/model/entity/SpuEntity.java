package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class SpuEntity extends BaseEntity {

    /**
     * 主键 - 商品ID
     */
    private Long id;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品详情
     */
    private String desc;

    /**
     * 商品详情主图
     */
    private String descPic;

    /**
     * 商品展示图, 多个图片逗号分隔
     */
    private String productPics;

    /**
     * 售价，整数方式保存
     */
    private Long price;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Byte status;


}
