package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpuAppSearchVO {

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("spu名称")
    private String spuName;

    @ApiModelProperty("商品详情")
    private String spuDesc;

    @ApiModelProperty("商品介绍主图")
    private String descImgUrl;

    @ApiModelProperty("售价")
    private Long price;

    @ApiModelProperty("商品销量")
    private Long sales;

    @ApiModelProperty("总库存")
    private Long totalStock;

}
