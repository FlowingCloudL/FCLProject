package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SpuModifyDTO {

    @ApiModelProperty("spuId")
    private Long spuId;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @NotNull(message = "分类不能为空")
    @ApiModelProperty("分类ID")
    private Long categoryId;

    @NotNull(message = "商品名称不能为空")
    @ApiModelProperty("spu名称")
    private String name;

    @NotNull(message = "商品轮播图不能为空")
    @ApiModelProperty("商品展示图url 多个图片逗号分隔")
    private String productPics;

    @ApiModelProperty("商品详情")
    private String desc;

    @NotNull(message = "商品详情主图不能为空")
    @ApiModelProperty("商品详情主图")
    private String descPic;

    @NotNull(message = "售价不能为空")
    @ApiModelProperty("售价")
    private Long price;

    @ApiModelProperty("商品属性值列表")
    private List<SpuBasicAttrDTO> spuBasicAttrs;

    @NotEmpty(message = "SKU信息不能为空")
    @ApiModelProperty("商品SKU列表")
    private List<SkuDTO> skuList;

    @ApiModelProperty("分组id")
    private Long tagId;

    @ApiModelProperty("序号")
    private Integer seq;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //==================================== 额外需求 ====================================

    @ApiModelProperty("spuId列表(商品上下架：批量操作时，用此参数)(批量处理参数)")
    private List<Long> spuIds;

}
