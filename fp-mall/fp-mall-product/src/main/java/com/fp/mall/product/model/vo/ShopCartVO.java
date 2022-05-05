package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShopCartVO {

    @ApiModelProperty(value = "店铺ID", required = true)
    private Long shopId;

    @ApiModelProperty(value = "店铺名称", required = true)
    private String shopName;

    @ApiModelProperty("店铺类型 | 1:自营店, 2:普通店")
    private Integer shopType;

    @ApiModelProperty("购物车商品信息")
    private List<ShopCartItemVO> shopCartItem;

    @ApiModelProperty(value = "商品总数", required = true)
    private Integer totalCount;

    @ApiModelProperty(value = "商品总价", required = true)
    private Long totalPrice;

}
