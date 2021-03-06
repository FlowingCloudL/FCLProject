package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    @ApiModelProperty("分类id")
    private Long categoryId;

    @NotNull(message = "分类名称不能为空")
    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类层级 从0开始")
    private Short categoryLevel;

    @NotNull(message = "请选择上级分类")
    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("分类图标")
    private String iconUrl;

    @ApiModelProperty("排序")
    private Integer seq;

    @NotNull(message = "状态不能为空")
    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;


}
