package com.fp.api.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("远程调用-订单SKU-BO")
public class OrderSkuBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("SKU编号")
    private Long skuId;

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("SKU名称")
    private String skuName;

    @ApiModelProperty("SKU描述")
    private String skuDesc;

    @ApiModelProperty("SKU图片URL")
    private String skuImgUrl;

    @ApiModelProperty("SKU销售属性 [字符串格式]")
    private String skuAttrs;

    @ApiModelProperty("SKU售价")
    private BigDecimal price;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
