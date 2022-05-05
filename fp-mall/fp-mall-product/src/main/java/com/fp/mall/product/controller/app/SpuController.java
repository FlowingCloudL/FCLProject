package com.fp.mall.product.controller.app;

import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.model.vo.SpuAppVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户端-SPU-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 21:13
 */
@Api("用户端-SPU-前端控制器")
@RestController
@RequestMapping("/app/spu")
public class SpuController {

    @GetMapping("/bySpuId")
    @ApiOperation(value = "商品详情信息", notes = "通过商品ID")
    public ResponseVO<SpuAppVO> prodInfo(@RequestParam("spuId") Long spuId) {
        return null;
    }

}
