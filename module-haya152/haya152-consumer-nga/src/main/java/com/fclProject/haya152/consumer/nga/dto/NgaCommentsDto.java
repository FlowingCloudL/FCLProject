package com.fclProject.haya152.consumer.nga.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("评论实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgaCommentsDto {

    @ApiModelProperty("uid")
    private Integer uid;
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("层号")
    private Integer floor;
    @ApiModelProperty("评论日期")
    private String date;
    @ApiModelProperty("点赞数")
    private Integer like;
    @ApiModelProperty("评论内容")
    private String comments;
    @ApiModelProperty("评论标签（分类）")
    private Integer tag;//0 无   1 回复   2 同传

}
