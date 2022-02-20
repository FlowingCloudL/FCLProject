package com.github.FlowingCloudL.haya152.nga.app.dto;

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
