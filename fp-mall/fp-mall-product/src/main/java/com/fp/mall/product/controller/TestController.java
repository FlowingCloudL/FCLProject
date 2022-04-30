package com.fp.mall.product.controller;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.common.core.util.PageUtil;
import com.fp.mall.product.mapper.AttrMapper;
import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.vo.AttrVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private AttrMapper attrMapper;

    @GetMapping("/attr/test1")
    PageVO<Object> test1() {
        AttrDTO attrDTO = new AttrDTO();
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPageNum(1);
        pageDTO.setPageSize(3);
        return PageUtil.doPage(pageDTO, ()->attrMapper.list(attrDTO));
    }
}
