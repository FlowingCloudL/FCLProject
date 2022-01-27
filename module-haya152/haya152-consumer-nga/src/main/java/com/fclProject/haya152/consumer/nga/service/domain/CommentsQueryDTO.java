package com.fclProject.haya152.consumer.nga.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("评论查询DTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsQueryDTO {
    @ApiModelProperty(value = "楼号", example = "[1,5,6]", required = true, position = 1)
    private List<Integer> noList;
    @ApiModelProperty(value = "用户uid", example = "61692441", position = 2)
    private Integer uid;
    @ApiModelProperty(value = "用户名", example = "FlowingCloudL", position = 3)
    private String name;
    @ApiModelProperty(value = "层号", example = "777", position = 4)
    private Integer floor;
    @ApiModelProperty(value = "模糊搜索关键词", example = "花瓶", position = 5)
    private String fuzzyKey;
    @ApiModelProperty(value = "评论标签(0:普通,1:回复,2:同传)", example = "2", position = 6)
    private Integer tag;
    @ApiModelProperty(value = "开始日期", example = "2022-01-01 12:00:00", position = 7)
    private String startDatetime;
    @ApiModelProperty(value = "结束日期", example = "2022-01-02 12:00:00", position = 8)
    private String endDatetime;
    @ApiModelProperty(value = "排序标准", example = "`like`", position = 9)
    private String orderBy;
    @ApiModelProperty(value = "排序顺序", example = "2", position = 10)
    private Integer order;
    @ApiModelProperty(value = "页码", example = "7", position = 11)
    private Integer pageNum;
    @ApiModelProperty(value = "单页条数", example = "100", position = 12)
    private Integer pageSize;
}
