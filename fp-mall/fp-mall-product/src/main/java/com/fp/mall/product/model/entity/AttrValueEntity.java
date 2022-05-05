package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

@Data
public class AttrValueEntity extends BaseEntity {

    private Long id;
    private Long attrId;
    private String value;
}
