package com.fp.mall.order.feign;

import com.fp.mall.order.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fp-mall-pay")
public interface PayService {

    @RequestMapping("/pay/{uid}/{money}")
    ResponseDTO pay(@PathVariable("uid") @RequestBody Integer uid,
                    @PathVariable("money") @RequestBody Integer money);
}
