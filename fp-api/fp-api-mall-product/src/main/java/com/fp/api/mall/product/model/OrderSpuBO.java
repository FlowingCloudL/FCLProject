package com.fp.api.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("远程调用-订单SPU-BO")
public class OrderSpuBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("商品名称")
    private String spuName;

    @ApiModelProperty("商品介绍")
    private String spuDesc;

    @ApiModelProperty("商品介绍主图")
    private String descImgUrl;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("对应的SKU")
    private OrderSkuBO skuBO;
}
