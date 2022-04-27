package com.fp.common.core.util;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PageUtil {
    public static <T> PageVO<T> doPage(PageDTO pageDTO, ISelect select) {
        PageInfo<T> pageResult = PageHelper
                .startPage(pageDTO.getPageNum(), pageDTO.getPageSize())
                .doSelectPageInfo(select);
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setPageNum(pageResult.getPageNum());
        pageVO.setPageSize(pageResult.getPageSize());
        pageVO.setTotalCount(pageResult.getTotal());
        pageVO.setTotalPages(pageResult.getPages());
        pageVO.setContent(pageResult.getList());
        return pageVO;
    }

    private static int getPages(long total, int pageSize) {
        if (total == -1) {
            return 1;
        }
        if (pageSize > 0) {
            return (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        }
        return  0;
    }
}
