package com.fp.mall.product.controller.app;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.model.dto.BrandDTO;
import com.fp.mall.product.model.vo.BrandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户端-品牌-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 19:55
 */
@Api("用户端-品牌-前端控制器")
@RestController
@RequestMapping("/app/brand")
public class BrandController {


    @GetMapping("/page")
    @ApiOperation(value = "分页获取品牌信息列表", notes = "分页获取")
    public ResponseVO<PageVO<BrandVO>> page(@Valid PageDTO pageDTO, BrandDTO brandDTO) {
        return null;
    }

    @GetMapping("/recommend/top")
    @ApiOperation(value = "获取置顶品牌列表", notes = "获取置顶品牌列表")
    public ResponseVO<List<BrandVO>> getTopBrand() {
        return null;
    }

    @GetMapping("/recommend/byCategoryId")
    @ApiOperation(value = "分类-推荐品牌信息列表", notes = "通过分类id")
    public ResponseVO<List<BrandVO>> getTopBrandList(@RequestParam("categoryId") Long categoryId) {
        return null;
    }

}
