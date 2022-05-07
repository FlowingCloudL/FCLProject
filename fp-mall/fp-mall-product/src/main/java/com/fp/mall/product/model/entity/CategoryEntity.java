package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class CategoryEntity extends BaseEntity {

    private Long categoryId;

    private String categoryName;

    private Short categoryLevel;

    private Long parentId;

    private String iconUrl;

    private Byte status;

}
