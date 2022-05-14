package com.fp.mall.order.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单项信息表
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@ApiModel("订单项信息DTO")
public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("商品名")
    private String spuName;

    @ApiModelProperty("商品图片URL")
    private String spuImgUrl;

    @ApiModelProperty("商品品牌id")
    private String brandId;

    @ApiModelProperty("商品分类id")
    private Long categoryId;

    @ApiModelProperty("商品sku编号")
    private Long skuId;

    @ApiModelProperty("商品sku名称")
    private String skuName;

    @ApiModelProperty("商品sku图片URL")
    private String skuImgUrl;

    @ApiModelProperty("商品销售属性（JSON）")
    private String skuAttrs;

    @ApiModelProperty("商品购买的数量")
    private Integer skuQuantity;

    @ApiModelProperty("商品sku价格")
    private BigDecimal skuPrice;

    @ApiModelProperty("折扣金额")
    private BigDecimal discountAmount;

    @ApiModelProperty("实际金额")
    private BigDecimal realAmount;

}
