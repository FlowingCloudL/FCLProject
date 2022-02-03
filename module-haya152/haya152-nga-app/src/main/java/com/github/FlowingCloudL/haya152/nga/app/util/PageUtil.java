package com.github.FlowingCloudL.haya152.nga.app.util;

import com.github.FlowingCloudL.haya152.nga.app.dto.PageRequest;
import com.github.FlowingCloudL.haya152.nga.app.dto.PageResult;
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
