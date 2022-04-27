package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;

public class AttrValueEntity extends BaseEntity {

    private Long id;
    private Long attrId;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AttrValueEntity{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", attrId=" + attrId +
                ", value='" + value + '\'' +
                '}';
    }
}
