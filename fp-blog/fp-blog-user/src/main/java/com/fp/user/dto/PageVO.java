package com.fp.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private List<T> dataList;
}
