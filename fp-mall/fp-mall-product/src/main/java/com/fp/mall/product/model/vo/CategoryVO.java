package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVO extends BaseVO {

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类层级 从0开始")
    private Short categoryLevel;

    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("分类图标")
    private String iconUrl;

    @ApiModelProperty("排序")
    private Integer seq;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //=================================== 附加 ===================================

    @ApiModelProperty("子分类列表")
    private List<CategoryVO> categories;

}
