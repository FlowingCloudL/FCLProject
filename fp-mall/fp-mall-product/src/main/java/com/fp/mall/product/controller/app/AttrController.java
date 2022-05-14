package com.fp.mall.product.controller.app;

import com.fp.common.core.model.ResponseVO;
import com.fp.common.core.util.ValidUtil;
import com.fp.mall.product.model.vo.AttrVO;
import com.fp.mall.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户端-属性-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 17:26
 */
@Api("用户端-属性-前端控制器")
@RestController("用户端-属性-前端控制器")
@RequestMapping("/app/attr")
public class AttrController {

    @Resource
    private AttrService attrService;

    @GetMapping
    @ApiOperation(value = "获取属性信息", notes = "通过属性id")
    public ResponseVO<AttrVO> getByAttrId(@RequestParam("attrId") Long attrId) {
        ValidUtil.checkNotNull(attrId);
        return ResponseVO.success(attrService.getAttrByAttrId(attrId));
    }

}
