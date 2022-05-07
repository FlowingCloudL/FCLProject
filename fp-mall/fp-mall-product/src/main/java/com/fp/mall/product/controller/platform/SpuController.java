package com.fp.mall.product.controller.platform;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.common.core.model.ResponseVO;
import com.fp.common.core.util.ValidUtil;
import com.fp.mall.product.model.dto.SpuDTO;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.vo.SpuVO;
import com.fp.mall.product.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

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

    @Resource
    private SpuService spuService;

    //================================================= GET =================================================

    @GetMapping
    @ApiOperation(value = "获取商品信息", notes = "通过商品Id")
    public ResponseVO<SpuVO> getBySpuId(@RequestParam("spuId") Long spuId) {
        ValidUtil.checkNotNull(spuId);
        SpuVO spuVO = spuService.getSpuBySpuId(spuId);
        return ResponseVO.success(spuVO);
    }

    //================================================= POST =================================================

    @PostMapping
    @ApiOperation(value = "保存商品", notes = "保存商品信息")
    public ResponseVO<Void> save(@Valid @RequestBody SpuDTO spuDTO) {
        spuService.saveSpu(spuDTO);
        return ResponseVO.success();
    }

    //================================================= PUT =================================================

    @PutMapping
    @ApiOperation(value = "更新商品", notes = "更新商品信息")
    public ResponseVO<Void> update(@Valid @RequestBody SpuDTO spuDTO) {
        spuService.updateSpu(spuDTO);
        return ResponseVO.success();
    }

    @PutMapping("/on")
    @ApiOperation(value = "商品批量上架", notes = "商品批量上架")
    public ResponseVO<Void> onTheShelf(@RequestParam("spuIds") List<Long> spuIds) {
        spuService.onTheShelf(spuIds);
        return ResponseVO.success();
    }

    @PutMapping("/off")
    @ApiOperation(value = "商品批量下架", notes = "商品批量下架")
    public ResponseVO<Void> offTheShelf(@RequestParam("spuIds") List<Long> spuIds) {
        spuService.offTheShelf(spuIds);
        return ResponseVO.success();
    }

    //================================================ DELETE ================================================

    @DeleteMapping
    @ApiOperation(value = "删除商品", notes = "通过商品id")
    public ResponseVO<Void> delete(@RequestParam("spuId") Long spuId) {
        ValidUtil.checkNotNull(spuId);
        spuService.deleteSpuBySpuId(spuId);
        return ResponseVO.success();
    }

}
