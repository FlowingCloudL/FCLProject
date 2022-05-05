package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AttrVO extends BaseVO {

    @ApiModelProperty("属性id")
    private Long id;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("属性名称")
    private String name;

    @ApiModelProperty("属性描述")
    private String desc;

    @ApiModelProperty("属性类型 | 0:基本属性, 1:销售属性")
    private Byte type;

    @ApiModelProperty("是否可以搜索 | 0:不可以, 1:可以")
    private Byte searchable;

    //============================================= 附加 =============================================

    @ApiModelProperty("属性值列表")
    private List<AttrValueVO> attrValues;

}
