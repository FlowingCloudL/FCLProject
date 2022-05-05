package com.fp.mall.product.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpuAppVO {

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("spu名称")
    private String name;

    @ApiModelProperty("商品详情")
    private String desc;

    @ApiModelProperty("商品介绍主图")
    private String descPic;

    @ApiModelProperty("商品展示图, 多个图片逗号分隔")
    private String productPics;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("商品销量")
    private Integer sales;

    @ApiModelProperty("总库存")
    private Integer totalStock;

    @ApiModelProperty("规格属性")
    private List<SpuBasicAttrVO> spuAttrValues;

    @ApiModelProperty("sku列表")
    private List<SkuAppVO> skus;



}
