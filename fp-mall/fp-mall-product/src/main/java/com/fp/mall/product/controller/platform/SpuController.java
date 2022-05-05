package com.fp.mall.product.controller.platform;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.model.dto.SpuDTO;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.vo.SpuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 平台端-SPU-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 17:17
 */
@Api("平台端-SPU-前端控制器")
@RestController
@RequestMapping("/platform/spu")
public class SpuController {

    //================================================= GET =================================================

    @GetMapping("/page")
    @ApiOperation(value = "获取商品信息列表", notes = "分页获取")
    public ResponseVO<PageVO<SpuVO>> platformPage(PageDTO pageDTO, SpuSearchDTO spuDTO) {
        return null;
    }

    @GetMapping
    @ApiOperation(value = "获取商品信息", notes = "通过商品Id")
    public ResponseVO<SpuVO> getBySpuId(@RequestParam("spuId") Long spuId) {
        return null;
    }

    //================================================= POST =================================================

    @PostMapping
    @ApiOperation(value = "保存商品信息", notes = "保存商品信息")
    public ResponseVO<Void> save(@Valid @RequestBody SpuDTO spuDTO) {
        return null;
    }

    //================================================= PUT =================================================

    @PutMapping
    @ApiOperation(value = "更新商品信息", notes = "更新商品信息")
    public ResponseVO<Void> update(@Valid @RequestBody SpuDTO spuDTO) {
        return null;
    }

    @PutMapping("/status")
    @ApiOperation(value = "商品上下架", notes = "商品上下架")
    public ResponseVO<Void> spuChangeStatus(@RequestBody SpuDTO spuDTO) {
        return null;
    }

    //================================================ DELETE ================================================

    @DeleteMapping
    @ApiOperation(value = "删除商品信息", notes = "通过商品id")
    public ResponseVO<Void> delete(@RequestParam("spuId") Long spuId) {
        return null;
    }

}
