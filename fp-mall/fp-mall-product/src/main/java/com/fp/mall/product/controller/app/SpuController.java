package com.fp.mall.product.controller.app;

import com.fp.common.core.model.PageVO;
import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.es.EsProductService;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.vo.SpuAppSearchVO;
import com.fp.mall.product.model.vo.SpuVO;
import com.fp.mall.product.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 用户端-SPU-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 21:13
 */
@Api("用户端-SPU-前端控制器")
@RestController("用户端-SPU-前端控制器")
@RequestMapping("/app/spu")
public class SpuController {

    @Resource
    private SpuService spuService;

    @Resource
    private EsProductService esProductService;

    @GetMapping("/search")
    public ResponseVO<PageVO<SpuAppSearchVO>> searchSpu(@RequestBody SpuSearchDTO spuSearchDTO) {
        PageVO<SpuAppSearchVO> pageVO = null;
        try {
            pageVO = esProductService.searchSpu(spuSearchDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseVO.success(pageVO);
    }

    @GetMapping("/spuId")
    @ApiOperation(value = "商品详情信息", notes = "通过商品ID")
    public ResponseVO<SpuVO> prodInfo(@RequestParam("spuId") Long spuId) {
        Assert.notNull(spuId, "商品id不能为空！");
        SpuVO spuVO = spuService.getSpuBySpuId(spuId);
        return ResponseVO.success(spuVO);
    }

}
