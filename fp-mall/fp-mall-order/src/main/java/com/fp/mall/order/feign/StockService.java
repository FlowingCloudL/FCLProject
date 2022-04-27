package com.fp.mall.order.feign;

import com.fp.mall.order.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fp-mall-stock")
public interface StockService {

    @RequestMapping("/stock/reduce/{id}/{num}")
    ResponseDTO reduce(@PathVariable("id") Integer id,
                       @PathVariable("num") Integer num);
}
