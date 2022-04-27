package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class BrandEntity extends BaseEntity {

    /**
     * 主键 - 品牌id
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌描述
     */
    private String desc;

    /**
     * 品牌logo图片
     */
    private String logoUrl;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Byte status;

}
