package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AttrVO extends BaseVO {

    @ApiModelProperty("属性id")
    private Long attrId;

    @ApiModelProperty("属性名称")
    private String attrName;

    @ApiModelProperty("属性类型 [0:销售属性，1:基本属性]")
    private Byte attrType;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("是否可以搜索 [0:不可以, 1:可以]")
    private Byte searchable;

    @ApiModelProperty("状态 [0:禁用, 1:启用]")
    private Byte status;

    //========================================== 附加 ==========================================

    @ApiModelProperty("基本属性值列表")
    private List<SpuBasicAttrVO> spuBasicAttrVOList;

}
