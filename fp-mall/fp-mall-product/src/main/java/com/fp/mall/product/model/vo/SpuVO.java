package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpuVO extends BaseVO {

    @ApiModelProperty("SPU id")
    private Long spuId;

    @ApiModelProperty("SPU名称")
    private String spuName;

    @ApiModelProperty("商品详情")
    private String spuDesc;

    @ApiModelProperty("商品详情主图url")
    private String descImgUrl;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("状态 | 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //=================================== 额外需求 ===================================

    @ApiModelProperty("分类信息")
    private CategoryVO category;

    @ApiModelProperty("SPU基本属性列表")
    private List<SpuBasicAttrVO> SpuBasicAttrList;

    @ApiModelProperty("sku列表")
    private List<SkuVO> skus;

    @ApiModelProperty("总库存")
    private Integer totalStock;

    @ApiModelProperty("商品销量")
    private Integer saleNum;
}
