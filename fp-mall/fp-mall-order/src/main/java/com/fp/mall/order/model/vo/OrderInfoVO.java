package com.fp.mall.order.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@ApiModel("订单信息VO")
public class OrderInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("订单来源 [0:PC订单；1:app订单]")
    private Integer orderSource;

    @ApiModelProperty("订单状态 [0:待付款；1:待发货；2:已发货；3:已完成；4:已关闭；5:无效订单]")
    private Integer orderStatus;

    @ApiModelProperty("订单备注")
    private String orderNote;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("订单总额")
    private BigDecimal totalAmount;

    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;

    @ApiModelProperty("折扣金额")
    private BigDecimal discountAmount;

    @ApiModelProperty("应付总额")
    private BigDecimal payAmount;

    @ApiModelProperty("支付方式 [1:支付宝；2:微信；3:银联； 4:货到付款]")
    private Integer payType;

    @ApiModelProperty("物流单号")
    private String deliverySn;

    @ApiModelProperty("收货人姓名")
    private String receiverName;

    @ApiModelProperty("收货人电话")
    private String receiverPhone;

    @ApiModelProperty("收货人邮编")
    private String receiverPostCode;

    @ApiModelProperty("省份/直辖市")
    private String receiverProvince;

    @ApiModelProperty("城市")
    private String receiverCity;

    @ApiModelProperty("区")
    private String receiverRegion;

    @ApiModelProperty("详细地址")
    private String receiverDetailAddress;

    @ApiModelProperty("确认收货状态 [0:未确认；1:已确认]")
    private Integer confirmStatus;

    @ApiModelProperty("删除状态 [0:未删除；1:已删除]")
    private Integer deleteStatus;

    @ApiModelProperty("支付时间")
    private LocalDateTime paymentTime;

    @ApiModelProperty("发货时间")
    private LocalDateTime deliveryTime;

    @ApiModelProperty("确认收货时间")
    private LocalDateTime receiveTime;

    @ApiModelProperty("评价时间")
    private LocalDateTime commentTime;

    @ApiModelProperty("创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty("更新日期")
    private LocalDateTime updateTime;


}
