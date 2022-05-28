package com.fp.mall.product.controller;

import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.es.EsProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class TestController {

    @Resource
    private EsProductService esProductService;

    @RequestMapping("/es/import")
    public ResponseVO<Void> testImport() {
        esProductService.importAll();
        return ResponseVO.success();
    }
}
