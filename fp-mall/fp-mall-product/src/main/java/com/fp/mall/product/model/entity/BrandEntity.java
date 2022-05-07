package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class BrandEntity extends BaseEntity {

    /**
     * 主键 - 品牌id
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌描述
     */
    private String brandDesc;

    /**
     * 品牌logo图片
     */
    private String logoUrl;

    /**
     * 检索首字母
     */
    private Character firstLetter;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 状态 [0:禁用, 1:启用]
     */
    private Byte status;

}
