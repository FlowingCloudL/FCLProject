package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class AttrEntity extends BaseEntity {

    private Long id;
    private Long categoryId;
    private String name;
    private String desc;
    private Byte type;
    private Byte searchable;

}
