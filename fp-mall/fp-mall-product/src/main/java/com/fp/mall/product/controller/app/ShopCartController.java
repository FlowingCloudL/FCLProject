package com.fp.mall.product.controller.app;

import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.model.dto.ShopCartCheckDTO;
import com.fp.mall.product.model.dto.ShopCartModifyDTO;
import com.fp.mall.product.model.vo.ShopCartAllVO;
import com.fp.mall.product.model.vo.ShopCartAmountVO;
import com.fp.mall.product.model.vo.ShopCartItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户端-购物车-前端控制器
 *
 * @author FlowingCloudL
 * @date 2022/5/2 20:36
 */
@Api("用户端-购物车-前端控制器")
@RestController
@RequestMapping("/app/shopCart")
public class ShopCartController {

    //================================================= GET =================================================

    @GetMapping("/all")
    @ApiOperation(value = "获取用户的所有购物车信息", notes = "包括不同店铺")
    public ResponseVO<ShopCartAllVO> getAll() {
        return null;
    }

    @GetMapping("/amount")
    @ApiOperation(value = "获取用户购物车金额信息", notes = "包括不同店铺, 只计算勾选的商品")
    public ResponseVO<ShopCartAmountVO> getAmount() {
        return null;
    }

    @GetMapping("/count")
    @ApiOperation(value = "获取购物车总的商品数量", notes = "包括不同店铺, 只计算勾选的商品")
    public ResponseVO<Integer> getCount() {
        return null;
    }

    @GetMapping("/item/expiry")
    @ApiOperation(value = "获取购物车失效商品信息", notes = "获取购物车失效商品列表")
    public ResponseVO<List<ShopCartItemVO>> getExpiryItemList() {
        return null;
    }

    //================================================= POST =================================================

    @PostMapping("/item")
    @ApiOperation(value = "添加用户购物车物品", notes = "通过DTO")
    public ResponseVO<Void> addItem(@Valid @RequestBody ShopCartModifyDTO param) {
        return null;
    }

    //================================================= PUT =================================================

    @PutMapping("/item/check")
    @ApiOperation(value = "勾选购物车物品", notes = "勾选购物车物品")
    public ResponseVO<Void> checkItems(@Valid @RequestBody List<ShopCartCheckDTO> params) {
        return null;
    }

    @PutMapping("/item/count")
    @ApiOperation(value = "修改用户购物车物品的数量", notes = "只负责修改指定购物车项的商品数量")
    public ResponseVO<Void> modifyItemCount(@Valid @RequestBody List<ShopCartModifyDTO> params) {
        return null;
    }

    //================================================ DELETE ================================================

    @DeleteMapping("/item")
    @ApiOperation(value = "删除用户购物车的物品", notes = "通过购物车项id")
    public ResponseVO<Void> deleteItem(@RequestBody List<Long> shopCartItemIds) {
        return null;
    }

    @DeleteMapping("/item/all")
    @ApiOperation(value = "清空用户购物车所有物品", notes = "清空用户购物车所有物品")
    public ResponseVO<String> deleteItemAll() {
        return null;
    }


}
