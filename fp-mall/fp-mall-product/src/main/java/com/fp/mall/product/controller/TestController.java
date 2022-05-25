package com.fp.mall.product.controller;

import com.fp.common.core.model.PageVO;
import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.vo.SpuAppSearchVO;
import com.fp.mall.product.es.EsProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping
public class TestController {

    @Resource
    private EsProductService esProductService;

    @RequestMapping("/es")
    public ResponseVO<PageVO<SpuAppSearchVO>> testQuery(@RequestBody SpuSearchDTO spuSearchDTO) throws IOException {
        PageVO<SpuAppSearchVO> pageVO = esProductService.searchSpu(spuSearchDTO);
        return ResponseVO.success(pageVO);
    }

    @RequestMapping("/es/import")
    public ResponseVO<Void> testImport() {
        esProductService.importAll();
        return ResponseVO.success();
    }
}
