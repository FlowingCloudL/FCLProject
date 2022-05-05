package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShopCartAmountVO {

    @ApiModelProperty("原价总额")
    private Long originalAmount;

    @ApiModelProperty("最终总额(计算优惠后)")
    private Long finalAmount;

    @ApiModelProperty("优惠金额")
    private Long discountAmount;

    @ApiModelProperty("商品总数")
    private Integer itemCount;

}
