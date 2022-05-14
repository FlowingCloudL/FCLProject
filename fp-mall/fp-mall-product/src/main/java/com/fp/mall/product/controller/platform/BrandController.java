package com.fp.mall.product.controller.platform;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.common.core.model.ResponseVO;
import com.fp.common.core.util.ValidUtil;
import com.fp.mall.product.model.dto.BrandDTO;
import com.fp.mall.product.model.vo.BrandVO;
import com.fp.mall.product.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


/**
 * 平台端-品牌-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 15:40
 */
@Api("平台端-品牌-前端控制器")
@RestController("平台端-品牌-前端控制器")
@RequestMapping("/platform/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    //================================================= GET =================================================

    @GetMapping("/page")
    @ApiOperation(value = "获取品牌信息列表", notes = "分页获取")
    public ResponseVO<PageVO<BrandVO>> page(@Valid PageDTO pageDTO, BrandDTO brandDTO) {
        return null;
    }

    @GetMapping("/byBrandId")
    @ApiOperation(value = "获取品牌信息", notes = "通过品牌id")
    public ResponseVO<BrandVO> getByBrandId(@RequestParam("brandId") Long brandId) {
        ValidUtil.checkNotNull(brandId);
        return ResponseVO.success(brandService.getByBrandId(brandId));
    }

    @GetMapping("/byCategoryId")
    @ApiOperation(value = "获取品牌信息列表", notes = "通过分类id")
    public ResponseVO<List<BrandVO>> getBrandByCategoryId(@RequestParam("categoryId") Long categoryId) {
        ValidUtil.checkNotNull(categoryId);
        return ResponseVO.success(brandService.listByCategoryId(categoryId));
    }

    //================================================= POST =================================================

    @PostMapping
    @ApiOperation(value = "保存品牌信息", notes = "保存品牌信息")
    public ResponseVO<Void> save(@Valid @RequestBody BrandDTO brandDTO) {
        brandService.save(brandDTO);
        return ResponseVO.success();
    }

    //================================================= PUT =================================================

    @PutMapping()
    @ApiOperation(value = "更新品牌信息", notes = "更新品牌信息")
    public ResponseVO<Void> update(@Valid @RequestBody BrandDTO brandDTO) {
        brandService.update(brandDTO);
        return ResponseVO.success();
    }

    @PutMapping(value = "/status")
    @ApiOperation(value = "更新品牌状态（启用或禁用）", notes = "更新品牌状态（启用或禁用）")
    public ResponseVO<Void> updateBrandStatus(@RequestBody BrandDTO brandDTO) {
        ValidUtil.checkNotNull(brandDTO.getBrandId(), brandDTO.getStatus());
        brandService.changeBrandStatus(brandDTO);
        return ResponseVO.success();
    }

    //================================================ DELETE ================================================

    @DeleteMapping()
    @ApiOperation(value = "删除品牌信息", notes = "通过品牌id")
    public ResponseVO<Void> deleteByBrandId(@RequestParam("brandId") Long brandId) {
        ValidUtil.checkNotNull(brandId);
        brandService.deleteByBrandId(brandId);
        return ResponseVO.success();
    }
}
