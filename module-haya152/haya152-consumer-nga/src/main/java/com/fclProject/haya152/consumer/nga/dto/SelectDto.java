package com.fclProject.haya152.consumer.nga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectDto {
    private Integer no;
    private Integer uid;
    private String name;
    private Integer floor;
    private String fuzzy_key;
    private Integer tag;
    private String startDate;
    private String endDate;
    private String orderBy;
    private Integer order;
    private Integer limit;
    private Integer type;
}
