package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;

public class AttrValueVO extends BaseVO {

    @ApiModelProperty("属性值id")
    private Long id;
    @ApiModelProperty("属性id")
    private Long attrId;
    @ApiModelProperty("属性值")
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
        return "AttrValueVO{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", attrId=" + attrId +
                ", value='" + value + '\'' +
                '}';
    }
}
