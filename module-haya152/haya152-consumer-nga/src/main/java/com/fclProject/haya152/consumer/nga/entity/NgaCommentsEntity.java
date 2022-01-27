package com.fclProject.haya152.consumer.nga.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("评论实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgaCommentsEntity {

    @ApiModelProperty(value = "uid", example = "61692441")
    private Integer uid;
    @ApiModelProperty(value = "昵称", example = "FlowingCloudL")
    private String name;
//    @ApiModelProperty(value = "楼号", example = "6")
//    private Integer buildingNo;
    @ApiModelProperty(value = "层号", example = "7777")
    private Integer floor;
    @ApiModelProperty(value = "评论日期", example = "2022-01-01 12:00:00")
    private String date;
    @ApiModelProperty(value = "点赞数", example = "77")
    private Integer like;
    @ApiModelProperty(value = "评论内容", example = "哈哈哈哈")
    private String comments;
    @ApiModelProperty(value = "评论标签(0:无,1:回复,2:同传)", example = "0")
    private Integer tag;

}
