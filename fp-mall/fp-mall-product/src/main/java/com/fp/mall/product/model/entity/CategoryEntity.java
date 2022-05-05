package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class CategoryEntity extends BaseEntity {

    private Long id;

    private Short level;

    private Long parentId;

    private String name;

    private String desc;

    private String iconUrl;

    private Byte status;

}
