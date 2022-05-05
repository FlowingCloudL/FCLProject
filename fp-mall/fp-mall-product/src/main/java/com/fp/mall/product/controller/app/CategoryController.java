package com.fp.mall.product.controller.app;

import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.model.vo.CategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户端-分类-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 20:27
 */
@Api("用户端-分类-前端控制器")
@RestController
@RequestMapping("/app/category")
public class CategoryController {

    @GetMapping("/parent")
    @ApiOperation(value = "获取指定分类下的分类列表", notes = "顶级分类的parentId为0, 默认为1级分类")
    public ResponseVO<List<CategoryVO>> listByParent(@RequestParam(value = "parentId", defaultValue = "0") Long parentId) {
        return null;
    }

}
