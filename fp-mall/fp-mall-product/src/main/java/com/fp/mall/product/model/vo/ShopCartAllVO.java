package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShopCartAllVO {

    @ApiModelProperty("原价总额")
    private Long originalAmount;

    @ApiModelProperty("最终总额(计算优惠后)")
    private Long finalAmount;

    @ApiModelProperty("商品总数")
    private Integer itemCount;

    @ApiModelProperty("多个店铺的购物车信息")
    private List<ShopCartVO> shopCarts;

}
