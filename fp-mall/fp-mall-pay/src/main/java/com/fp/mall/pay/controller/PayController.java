package com.fp.mall.pay.controller;

import com.fp.mall.pay.dto.ResponseDTO;
import com.fp.mall.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @RequestMapping("/pay/{uid}/{money}")
    public ResponseDTO payMoney(@PathVariable("uid") Integer uid,
                                @PathVariable("money") Integer money) {

        payService.pay(uid, money);
        return ResponseDTO.getSuccess();

    }

}
