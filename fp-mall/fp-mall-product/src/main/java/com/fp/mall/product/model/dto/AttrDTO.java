package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AttrDTO {

    @ApiModelProperty("attr id")
    private Long id;

    @NotNull(message = "属性名称不能为空")
    @ApiModelProperty("属性名称")
    private String name;

    @ApiModelProperty("属性描述")
    private String desc;

    @ApiModelProperty("属性类型 | 0:销售属性，1:基本属性")
    private Byte type;

    @ApiModelProperty("属性值列表")
    private List<AttrValueDTO> attrValues;

    @ApiModelProperty("分类id列表")
    private List<Long> categoryIds;

    @ApiModelProperty("是否可以搜索 | 0:不可以, 1:可以")
    private Byte searchable;
}
