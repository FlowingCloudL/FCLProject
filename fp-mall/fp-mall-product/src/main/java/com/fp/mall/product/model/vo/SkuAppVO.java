package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;

public class SkuAppVO {

    @ApiModelProperty("库存id")
    private Long skuId;

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("库存名称")
    private String skuName;

    @ApiModelProperty("库存图片")
    private String imgUrl;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("库存量")
    private Integer stock;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("属性")
    private String properties;

}
