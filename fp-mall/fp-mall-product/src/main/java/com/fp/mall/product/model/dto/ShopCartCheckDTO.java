package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ShopCartCheckDTO {

    @NotNull
    @ApiModelProperty(value = "购物车项ID", required = true)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "商品是否勾选 | 1:勾选 0:未勾选")
    private Byte Checked;

}
