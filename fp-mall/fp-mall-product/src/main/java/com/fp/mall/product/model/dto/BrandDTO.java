package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BrandDTO {

    @ApiModelProperty("品牌id")
    private Long id;

    @NotNull(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌描述")
    private String desc;

    @NotNull(message = "logo图片不能为空")
    @ApiModelProperty("品牌logo图片")
    private String logoUrl;

    @NotNull(message = "序号不能为空")
    @ApiModelProperty("排序")
    private Integer seq;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //============================== 额外需求 ==============================

    @NotNull(message = "分类不能为空")
    @ApiModelProperty("分类")
    private List<Long> categoryIds;
}
