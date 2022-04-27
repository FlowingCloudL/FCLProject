package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttrValueDTO {

    @ApiModelProperty("属性id")
    private Long id;

    @ApiModelProperty("属性ID")
    private Long attrId;

    @ApiModelProperty("属性值")
    private String value;

}
