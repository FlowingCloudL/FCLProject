package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SkuAppVO {

    @ApiModelProperty("库存id")
    private Long skuId;

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("库存名称")
    private String skuName;

    @ApiModelProperty("SKU介绍")
    private String skuDesc;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("库存量")
    private Integer stock;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("销售属性列表")
    private List<SkuSaleAttrVO> skuSaleAttrList;

}
