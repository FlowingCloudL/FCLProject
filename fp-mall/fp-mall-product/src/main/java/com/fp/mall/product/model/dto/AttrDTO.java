package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AttrDTO {

    @ApiModelProperty("属性id")
    private Long attrId;

    @NotNull(message = "属性名称不能为空")
    @ApiModelProperty("属性名称")
    private String attrName;

    @ApiModelProperty("属性类型 [0:销售属性，1:基本属性]")
    private Byte attrType;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("是否可以搜索 [0:不可以, 1:可以]")
    private Byte searchable;

    @ApiModelProperty("状态 [0:禁用, 1:启用]")
    private Byte status;
}
