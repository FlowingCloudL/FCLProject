package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class AttrEntity extends BaseEntity {

    private Long attrId;

    private String attrName;

    private Byte attrType;

    private Long categoryId;

    private Byte searchable;

    private Byte status;

}
