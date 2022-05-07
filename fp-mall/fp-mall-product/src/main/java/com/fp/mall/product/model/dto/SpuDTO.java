package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SpuDTO {

    @ApiModelProperty("spuId")
    private Long spuId;

    @NotNull(message = "商品名称不能为空")
    @ApiModelProperty("spu名称")
    private String spuName;

    @ApiModelProperty("商品详情")
    private String spuDesc;

    @NotNull(message = "商品详情主图不能为空")
    @ApiModelProperty("商品详情主图")
    private String descImgUrl;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @NotNull(message = "分类不能为空")
    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //==================================== 附加 ====================================

    @ApiModelProperty("商品属性值列表")
    private List<SpuBasicAttrDTO> spuBasicAttrs;

    @ApiModelProperty("spuId列表(商品上下架：批量操作时，用此参数)(批量处理参数)")
    private List<Long> spuIds;

}
