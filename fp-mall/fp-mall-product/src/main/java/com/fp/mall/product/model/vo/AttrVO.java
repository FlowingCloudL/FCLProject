package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import com.fp.mall.product.model.vo.CategoryVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AttrVO extends BaseVO {

    @ApiModelProperty("attr id")
    private Long id;

    @ApiModelProperty("属性名称")
    private String name;

    @ApiModelProperty("属性描述")
    private String desc;

    @ApiModelProperty("属性类型 | 0:基本属性, 1:销售属性")
    private Byte type;

    @ApiModelProperty("属性值列表")
    private List<AttrValueVO> attrValues;

    @ApiModelProperty("分类列表")
    private List<CategoryVO> categories;

    @ApiModelProperty("是否可以搜索 | 0:不可以, 1:可以")
    private Byte searchable;

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

    public Byte getSearchable() {
        return searchable;
    }

    public void setSearchable(Byte searchable) {
        this.searchable = searchable;
    }

    public List<AttrValueVO> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<AttrValueVO> attrValues) {
        this.attrValues = attrValues;
    }

    public List<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryVO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "AttrVO{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", attrValues=" + attrValues +
                ", categories=" + categories +
                ", searchable=" + searchable +
                '}';
    }
}
