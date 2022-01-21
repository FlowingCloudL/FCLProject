package com.fclProject.haya152.consumer.nga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectDto {
    private Integer no = 6;
    private Integer uid;
    private String name;
    private Integer floor;
    private Integer tag;
    private String startDate;
    private String endDate;
    private String orderBy;
    private Integer order;
    private Integer limit;
}
