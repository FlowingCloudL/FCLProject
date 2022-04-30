package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttrValueVO extends BaseVO {

    @ApiModelProperty("属性值id")
    private Long id;

    @ApiModelProperty("属性id")
    private Long attrId;

    @ApiModelProperty("属性值")
    private String value;

}
