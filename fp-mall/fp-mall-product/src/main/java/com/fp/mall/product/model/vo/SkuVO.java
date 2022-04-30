package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuVO extends BaseVO {

    @ApiModelProperty("SKU id")
    private Long id;

    @ApiModelProperty("SPU id")
    private Long spuId;

    @ApiModelProperty("SKU名称")
    private String name;

    @ApiModelProperty("多个销售属性值id逗号分隔")
    private String attrs;

    @ApiModelProperty("图片url")
    private String imgUrl;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Integer status;

    //=================================== 额外需求 ===================================

    @ApiModelProperty("SKU销售属性列表")
    private List<SkuSaleAttrVO> skuSaleAttrs;

}
