package com.github.FlowingCloudL.haya152.nga.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NGACommentsEntity {

    private String tableName;
    private Integer uid;
    private String name;
    private Integer floor;
    private String date;
    private Integer like;
    private String comments;
    private Integer tag; //0 无   1 回复   2 同传

}
