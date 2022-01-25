package com.fclProject.haya152.consumer.nga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    private int pageNum;
    private int pageSize;
}
