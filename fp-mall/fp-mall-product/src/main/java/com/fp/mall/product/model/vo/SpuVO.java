package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpuVO extends BaseVO {

    @ApiModelProperty("SPU id")
    private Long id;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("SPU名称")
    private String name;

    @ApiModelProperty("商品展示图url, 多个图片逗号分隔")
    private String productPics;

    @ApiModelProperty("商品详情")
    private String desc;

    @ApiModelProperty("商品详情主图url")
    private String descPic;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("状态 | 1:enable, 0:disable, -1:deleted")
    private Integer status;

    //=================================== 额外需求 ===================================

    @ApiModelProperty("分类信息")
    private CategoryVO category;

    @ApiModelProperty("SPU基本属性列表")
    private List<SpuBasicAttrVO> spuAttrValues;

    @ApiModelProperty("sku列表")
    private List<SkuVO> skus;

    @ApiModelProperty("总库存")
    private Integer totalStock;

    @ApiModelProperty("商品销量")
    private Integer saleNum;
}
