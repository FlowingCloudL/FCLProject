package com.fp.mall.product.model.entity;

import com.fp.common.core.model.BaseEntity;

import java.util.List;


public class AttrEntity extends BaseEntity {

    private Long id;
    private String name;
    private String desc;
    private Byte type;
    private Boolean searchable;
    private List<AttrValueEntity> attrValues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public List<AttrValueEntity> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<AttrValueEntity> attrValues) {
        this.attrValues = attrValues;
    }

    @Override
    public String toString() {
        return "AttrEntity{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", searchable=" + searchable +
                ", attrValues=" + attrValues +
                '}';
    }
}
