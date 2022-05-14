package com.fp.mall.product.controller.platform;

import com.fp.common.core.model.ResponseVO;
import com.fp.common.core.util.ValidUtil;
import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.vo.AttrVO;
import com.fp.mall.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 平台端-属性-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 14:19
 */
@Api("平台端-属性-前端控制器")
@RestController("平台端-属性-前端控制器")
@RequestMapping("/platform/attr")
public class AttrController {

    @Resource
    private AttrService attrService;

    //================================================ GET ================================================

//    @GetMapping("/page")
//    @ApiOperation(value = "获取属性列表", notes = "通过DTO, 分页获取")
//    public ResponseVO<PageVO<AttrVO>> getAttrsPage(@Valid PageDTO pageDTO, AttrDTO attrDTO){
//        return null;
//    }

    @GetMapping("/byAttrId")
    @ApiOperation(value = "获取属性", notes = "通过属性id获取")
    public ResponseVO<AttrVO> getAttrById(@RequestParam("attrId") Long attrId) {
        ValidUtil.checkNotNull(attrId);
        return ResponseVO.success(attrService.getAttrByAttrId(attrId));
    }

    @GetMapping("/byCategoryId")
    @ApiOperation(value = "获取属性列表", notes = "通过分类id")
    public ResponseVO<List<AttrVO>> getAttrsByCategoryId(@RequestParam("categoryId") Long categoryId) {
        ValidUtil.checkNotNull(categoryId);
        return ResponseVO.success(attrService.listAttrsByCategoryId(categoryId));
    }

    //================================================ POST ================================================

    @PostMapping
    @ApiOperation(value = "保存属性信息", notes = "通过DTO保存")
    public ResponseVO<Void> saveAttr(@RequestBody AttrDTO attrDTO) {
        attrService.saveAttr(attrDTO);
        return ResponseVO.success();
    }

    //================================================ PUT ================================================

    @PutMapping
    @ApiOperation(value = "更新属性信息", notes = "通过DTO更新")
    public ResponseVO<Void> updateAttr(@RequestBody AttrDTO attrDTO) {
        attrService.updateAttr(attrDTO);
        return ResponseVO.success();
    }

    //================================================ DELETE ================================================

    @DeleteMapping
    @ApiOperation(value = "删除属性信息", notes = "通过属性id删除")
    public ResponseVO<Void> deleteAttrById(@RequestParam("attrId") Long attrId) {
        ValidUtil.checkNotNull(attrId);
        attrService.deleteAttrByAttrId(attrId);
        return ResponseVO.success();
    }



}
