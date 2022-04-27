package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuDTO {

    @ApiModelProperty("SKU id")
    private Long id;

    @ApiModelProperty("SPU id")
    private Long spuId;

    @ApiModelProperty("sku名称")
    private String name;

    @ApiModelProperty("多个销售属性值id逗号分隔")
    private String attrs;

    @ApiModelProperty("销售属性列表")
    private List<SkuSaleAttrDTO> skuSaleAttrs;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("库存图url")
    private String imgUrl;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;

}
