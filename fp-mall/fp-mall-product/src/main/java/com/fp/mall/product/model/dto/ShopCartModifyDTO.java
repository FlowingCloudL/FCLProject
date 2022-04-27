package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShopCartModifyDTO {

    @ApiModelProperty(value = "购物车项ID", required = true)
    private Long id;

    @NotNull(message = "商品ID不能为空")
    @ApiModelProperty(value = "商品ID", required = true)
    private Long spuId;

    @ApiModelProperty(value = "旧的skuId 如果传过来说明在变更sku", required = true)
    private Long oldSkuId;

    @NotNull(message = "库存ID不能为空")
    @ApiModelProperty(value = "库存ID", required = true)
    private Long skuId;

    @NotNull(message = "商品个数不能为空")
    @ApiModelProperty(value = "商品个数", required = true)
    private Integer count;

    @ApiModelProperty(value = "商品是否勾选 | true:已勾选, false:不勾选")
    private Boolean Checked;

}
