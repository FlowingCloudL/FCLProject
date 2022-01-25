package com.fclProject.haya152.consumer.nga.util;

import com.fclProject.haya152.consumer.nga.dto.PageRequest;
import com.fclProject.haya152.consumer.nga.dto.PageResult;
import com.github.pagehelper.PageInfo;

public class PageUtil {
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
