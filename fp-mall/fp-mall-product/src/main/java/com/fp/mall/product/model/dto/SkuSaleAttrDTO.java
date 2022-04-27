package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SkuSaleAttrDTO {

    @ApiModelProperty("关联信息id")
    private Long id;

    @ApiModelProperty("SPU ID")
    private Long spuId;

    @ApiModelProperty("SKU ID")
    private Long skuId;

    @ApiModelProperty("销售属性ID")
    private Long attrId;

    @ApiModelProperty("销售属性名称")
    private String attrName;

    @ApiModelProperty("销售属性值ID")
    private Long attrValueId;

    @ApiModelProperty("销售属性值")
    private String attrValue;

    @ApiModelProperty("状态 1:enable, 0:disable")
    private Byte status;
}
