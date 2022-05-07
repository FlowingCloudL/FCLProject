package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BrandVO extends BaseVO {

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌描述")
    private String brandDesc;

    @ApiModelProperty("品牌logo图片")
    private String logoUrl;

    @ApiModelProperty("检索首字母")
    private Character firstLetter;

    @ApiModelProperty("排序")
    private Integer seq;

    @ApiModelProperty("状态 [0:禁用, 1:启用]")
    private Byte status;

    //============================== 附加 ==============================

    @ApiModelProperty("分类")
    private List<CategoryVO> categoryVOs;
}
