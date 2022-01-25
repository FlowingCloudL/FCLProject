package com.fclProject.haya152.consumer.nga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgaBuildingDto {
    private String building_name;
    private Integer building_no;
    private String tableName;
    private String startDatetime;
    private String endDatetime;
    private String url;
}
