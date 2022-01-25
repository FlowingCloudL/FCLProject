package com.fclProject.haya152.consumer.nga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgaCommentsDto {

    private Integer uid;
    private String name;
    private Integer floor;
    private String date;
    private Integer like;
    private String comments;
    private Integer tag;//0 无   1 回复   2 同传

}
