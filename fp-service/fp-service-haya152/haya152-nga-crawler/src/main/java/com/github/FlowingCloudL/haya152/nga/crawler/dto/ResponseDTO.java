package com.github.FlowingCloudL.haya152.nga.crawler.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {


    private Integer code;

    private String message;

    private Object data;
}
