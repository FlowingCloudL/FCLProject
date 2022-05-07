package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SkuSaleAttrVO extends BaseVO {

    @ApiModelProperty("关联信息id")
    private Long id;

    @ApiModelProperty("SKU ID")
    private Long skuId;

    @ApiModelProperty("销售属性ID")
    private Long attrId;

    @ApiModelProperty("销售属性名称")
    private String attrName;

    @ApiModelProperty("销售属性值")
    private String attrValue;

}
