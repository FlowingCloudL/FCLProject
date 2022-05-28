package com.fp.mall.sale.controller;

import com.fp.common.core.model.ResponseVO;
import com.fp.mall.sale.service.FlashSaleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/t")
public class TestController {

    @Resource
    private FlashSaleService flashSaleService;

    @GetMapping("/kill/{itemId}")
    public ResponseVO<String> testFlashSale(@PathVariable("itemId") Long itemId) {
        boolean ifSuccess = flashSaleService.purchase(itemId, 7L);
        if (ifSuccess) return ResponseVO.success("秒杀成功");
        else return ResponseVO.failForShow("秒杀失败");
    }

    @PostMapping("/import/{id}")
    public ResponseVO<Void> testImport(@PathVariable("id") Long id) {
        flashSaleService.importToRedis(id);
        return ResponseVO.success();
    }


}
