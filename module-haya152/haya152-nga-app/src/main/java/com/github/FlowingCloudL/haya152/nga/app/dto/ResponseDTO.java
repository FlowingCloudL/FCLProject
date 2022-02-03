package com.github.FlowingCloudL.haya152.nga.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("标准接口返回")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    @ApiModelProperty(value = "请求处理状态",example = "200", position = 1)
    private Integer code;

    @ApiModelProperty(value = "请求处理消息",example = "OK", position = 2)
    private String message;

    @ApiModelProperty(value = "请求处理数据",example = " ", position = 3)
    private Object data;
}
