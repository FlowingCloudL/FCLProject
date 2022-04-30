package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVO extends BaseVO {

    @ApiModelProperty("分类id")
    private Long id;

    @ApiModelProperty("分类层级 | 0为根分类")
    private Short level;

    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类描述")
    private String desc;

    @ApiModelProperty("分类图标")
    private String iconUrl;

    @ApiModelProperty("状态 | 1:enable, 0:disable, -1:deleted")
    private Byte status;

    //=================================== 附加 ===================================

    @ApiModelProperty("上级分类名称")
    private List<String> pathNames;

    @ApiModelProperty("子分类列表")
    private List<CategoryVO> categories;

}
