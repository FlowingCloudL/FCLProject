package com.fp.mall.order.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 退货信息表
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@ApiModel("退货信息DTO")
public class OrderReturnInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("商品SKU编号")
    private Long skuId;

    @ApiModelProperty("商品名称")
    private String skuName;

    @ApiModelProperty("商品品牌")
    private String skuBrand;

    @ApiModelProperty("商品销售属性(JSON)")
    private String skuAttrs;

    @ApiModelProperty("商品图片URL")
    private String skuImgUrl;

    @ApiModelProperty("商品单价")
    private BigDecimal skuPrice;

    @ApiModelProperty("实际支付金额")
    private BigDecimal realPrice;

    @ApiModelProperty("退款原因")
    private String returnReason;

    @ApiModelProperty("凭证图片，以逗号隔开")
    private String returnReasonImgsUrl;

    @ApiModelProperty("退货数量")
    private Integer returnCount;

    @ApiModelProperty("退款金额")
    private BigDecimal returnAmount;

    @ApiModelProperty("申请状态 [0:待处理；1:退货中；2:已完成；3:已拒绝]")
    private Boolean returnStatus;

    @ApiModelProperty("处理人员")
    private String handlePerson;

    @ApiModelProperty("处理备注")
    private String handleNote;

    @ApiModelProperty("处理时间")
    private LocalDateTime handleTime;


}
