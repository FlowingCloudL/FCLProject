package com.fp.mall.order.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("订单SKU提交DTO")
public class OrderSubmitSkuDTO {

    @ApiModelProperty("SKU ID")
    private Long skuId;

    @ApiModelProperty("数量")
    private Integer count;

}
