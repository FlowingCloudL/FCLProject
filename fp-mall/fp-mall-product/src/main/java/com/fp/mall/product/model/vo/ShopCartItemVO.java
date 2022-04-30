package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ShopCartItemVO extends BaseVO {

    @ApiModelProperty(value = "购物车物品ID", required = true)
    private Long id;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("商品ID")
    private Long spuId;

    @ApiModelProperty("库存ID")
    private Long skuId;

    @ApiModelProperty("商品个数")
    private Integer count;

    @ApiModelProperty("售价，加入购物车时的商品价格")
    private Long priceBefore;

    @ApiModelProperty("是否勾选 | 0:未勾选 1:已勾选")
    private Byte Checked;

    //========================================== 附加 ==========================================

    @ApiModelProperty("商品名称")
    private String spuName;

    @ApiModelProperty("sku销售属性信息")
    private String skuSaleAttr;

    @ApiModelProperty("商品图片")
    private String productPic;

    @ApiModelProperty("当前商品价格")
    private Long priceNow;

    @ApiModelProperty("当前总价格(商品价格 * 数量)")
    private Long totalPrice;



}
