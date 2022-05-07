package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BrandDTO {

    @ApiModelProperty("品牌id")
    private Long brandId;

    @NotNull(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌描述")
    private String brandDesc;

    @NotNull(message = "logo图片不能为空")
    @ApiModelProperty("品牌logo图片")
    private String logoUrl;

    @NotNull(message = "检索首字母不能为空")
    @ApiModelProperty("检索首字母")
    private Character firstLetter;

    @NotNull(message = "序号不能为空")
    @ApiModelProperty("排序")
    private Integer seq;

    @ApiModelProperty("状态 [0:禁用, 1:启用]")
    private Byte status;

    //============================== 附加 ==============================

    @NotNull(message = "分类不能为空")
    @ApiModelProperty("分类")
    private List<Long> categoryIds;
}
