package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SkuSaleAttrDTO {

    @ApiModelProperty("销售属性id [更新用, 其他时候可以为空]")
    private Long id;

    @ApiModelProperty("销售属性ID")
    private Long attrId;

    @ApiModelProperty("销售属性名称")
    private String attrName;

    @ApiModelProperty("销售属性值")
    private String attrValue;

}
