package com.fp.mall.product.controller.platform;

import com.fp.common.core.model.ResponseVO;
import com.fp.common.core.util.ValidUtil;
import com.fp.mall.product.model.dto.CategoryDTO;
import com.fp.mall.product.model.vo.CategoryVO;
import com.fp.mall.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 平台端-分类-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 16:28
 */
@Api("平台端-分类-前端控制器")
@RestController
@RequestMapping("/platform/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //================================================= GET =================================================

    @GetMapping
    @ApiOperation(value = "获取分类信息", notes = "通过分类id")
    public ResponseVO<CategoryVO> getByCategoryId(@RequestParam("categoryId") Long categoryId) {
        ValidUtil.checkNotNull(categoryId);
        return ResponseVO.success(categoryService.getCategoryByCategoryId(categoryId));
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取平台所有的分类信息", notes = "获取所有的分类列表信息")
    public ResponseVO<List<CategoryVO>> listAll() {
        List<CategoryVO> voList = categoryService.listCategories();
        return ResponseVO.success(voList);
    }

    @GetMapping("/byParentId")
    @ApiOperation(value = "根据父级id，获取分类信息列表", notes = "通过父级id")
    public ResponseVO<List<CategoryVO>> getListByParentId(@RequestParam("parentId") Long parentId) {
        ValidUtil.checkNotNull(parentId);
        List<CategoryVO> voList = categoryService.listCategoriesByParentId(parentId);
        return ResponseVO.success(voList);
    }

    //================================================= POST =================================================

    @PostMapping
    @ApiOperation(value = "保存分类信息", notes = "保存分类信息")
    public ResponseVO<Void> save(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
        return ResponseVO.success();
    }

    //================================================= PUT =================================================

    @PutMapping
    @ApiOperation(value = "更新分类信息", notes = "更新分类信息")
    public ResponseVO<Void> update(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
        return ResponseVO.success();
    }

    @PutMapping(value = "/enableOrDisable")
    @ApiOperation(value = "启用/禁用分类", notes = "启用/禁用")
    public ResponseVO<Void> enableOrDisable(@RequestParam("categoryId") Long categoryId, @RequestParam("status") Byte status) {
        ValidUtil.checkNotNull(categoryId, status);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryId);
        categoryDTO.setStatus(status);
        categoryService.update(categoryDTO);
        return ResponseVO.success();
    }

    //================================================ DELETE ================================================

    @DeleteMapping
    @ApiOperation(value = "删除分类信息", notes = "根据分类id")
    public ResponseVO<Void> delete(@RequestParam("categoryId") Long categoryId) {
        ValidUtil.checkNotNull(categoryId);
        categoryService.deleteByCategoryId(categoryId);
        return ResponseVO.success();
    }

}
