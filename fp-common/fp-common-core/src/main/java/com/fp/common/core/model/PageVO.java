package com.fp.common.core.model;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    /**
     * 当前页码
     */
    private int PageNum;

    /**
     * 页面大小(每页的记录条数)
     */
    private int pageSize;

    /**
     * 总记录条数
     */
    private long totalCount;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 数据列表
     */
    private List<T> content;
}
