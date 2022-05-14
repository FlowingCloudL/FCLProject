package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuDTO {

    @ApiModelProperty("SKU id")
    private Long skuId;

    @ApiModelProperty("SPU id")
    private Long spuId;

    @ApiModelProperty("sku名称")
    private String skuName;

    @ApiModelProperty("sku介绍")
    private String skuDesc;

    @ApiModelProperty("售价")
    private BigDecimal price;

    @ApiModelProperty("库存")
    private Long stock;

    @ApiModelProperty("销量")
    private Long sales;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //==================================== 附加 ====================================

    @ApiModelProperty("销售属性列表")
    private List<SkuSaleAttrDTO> skuSaleAttrs;

}
