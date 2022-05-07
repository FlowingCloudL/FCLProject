package com.fp.mall.product.controller.platform;

import com.fp.common.core.model.ResponseVO;
import com.fp.common.core.util.ValidUtil;
import com.fp.mall.product.consts.ProductStatusConst;
import com.fp.mall.product.model.dto.SkuDTO;
import com.fp.mall.product.model.dto.SpuDTO;
import com.fp.mall.product.model.vo.SkuVO;
import com.fp.mall.product.model.vo.SpuVO;
import com.fp.mall.product.service.SkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 平台端-SKU-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/7 17:22
 */
@Api("平台端-SKU-前端控制器")
@RestController
@RequestMapping("/platform/sku")
public class SkuController {

    @Resource
    private SkuService skuService;

    //================================================= GET =================================================

    @GetMapping
    @ApiOperation(value = "获取库存信息", notes = "通过库存Id")
    public ResponseVO<SkuVO> getBySkuId(@RequestParam("skuId") Long skuId) {
        ValidUtil.checkNotNull(skuId);
        SkuVO skuVO = skuService.getBySkuId(skuId);
        return ResponseVO.success(skuVO);
    }

    @GetMapping("/bySpuId")
    @ApiOperation(value = "获取库存信息列表", notes = "通过商品Id")
    public ResponseVO<List<SkuVO>> getBySpuId(@RequestParam("spuId") Long spuId) {
        ValidUtil.checkNotNull(spuId);
        List<SkuVO> voList = skuService.listBySpuId(spuId);
        return ResponseVO.success(voList);
    }

    //================================================= POST =================================================

    @PostMapping
    @ApiOperation(value = "保存库存信息", notes = "保存库存信息")
    public ResponseVO<Void> save(@Valid @RequestBody SkuDTO skuDTO) {
        skuService.save(skuDTO);
        return ResponseVO.success();
    }

    //================================================= PUT =================================================

    @PutMapping
    @ApiOperation(value = "更新库存信息", notes = "更新库存信息")
    public ResponseVO<Void> update(@Valid @RequestBody SkuDTO skuDTO) {
        skuService.update(skuDTO);
        return ResponseVO.success();
    }

    @PutMapping("/on")
    @ApiOperation(value = "库存批量上架", notes = "库存批量上架")
    public ResponseVO<Void> onTheShelf(@RequestParam("skuIds") List<Long> skuIds) {
        skuService.changeStatus(skuIds, ProductStatusConst.ON_THE_SHELF);
        return ResponseVO.success();
    }

    @PutMapping("/off")
    @ApiOperation(value = "库存批量下架", notes = "库存批量下架")
    public ResponseVO<Void> offTheShelf(@RequestParam("skuIds") List<Long> skuIds) {
        skuService.changeStatus(skuIds, ProductStatusConst.OFF_THE_SHELF);
        return ResponseVO.success();
    }

    //================================================ DELETE ================================================

    @DeleteMapping
    @ApiOperation(value = "删除库存", notes = "通过库存id")
    public ResponseVO<Void> delete(@RequestParam("skuId") Long skuId) {
        ValidUtil.checkNotNull(skuId);
        skuService.deleteBySkuId(skuId);
        return ResponseVO.success();
    }

}
