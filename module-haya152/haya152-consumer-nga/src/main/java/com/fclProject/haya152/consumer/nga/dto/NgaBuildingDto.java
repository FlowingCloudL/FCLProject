package com.fclProject.haya152.consumer.nga.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("楼实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgaBuildingDto {
    @ApiModelProperty("楼名")
    private String building_name;
    @ApiModelProperty("楼号")
    private Integer building_no;
    @ApiModelProperty("对应表名")
    private String tableName;
    @ApiModelProperty("最初评论日期")
    private String startDatetime;
    @ApiModelProperty("最终评论日期")
    private String endDatetime;
    @ApiModelProperty("楼链接")
    private String url;
}
