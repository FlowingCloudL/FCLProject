package com.fclProject.haya152.consumer.nga.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("楼实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgaBuildingEntity {
    @ApiModelProperty(value = "楼名", example = "6号专楼")
    private String buildingName;
    @ApiModelProperty(value = "楼号", example = "6")
    private Integer buildingNo;
    @ApiModelProperty(value = "对应表名", example = "nga06")
    private String tableName;
    @ApiModelProperty(value = "最初评论日期", example = "2022-01-01 12:00:00")
    private String startDatetime;
    @ApiModelProperty(value = "最终评论日期", example = "2022-01-01 12:00:00")
    private String endDatetime;
    @ApiModelProperty(value = "楼链接", example = "https://bbs.nga.cn/read.php?tid=30226559")
    private String url;
}
