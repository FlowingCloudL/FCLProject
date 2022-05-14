package com.fp.mall.order.model.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("order_info")
public class OrderInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    private Integer orderSource;

    private Integer orderStatus;

    private String orderNote;

    private Long userId;

    private String userName;

    private BigDecimal totalAmount;

    private BigDecimal freightAmount;

    private BigDecimal discountAmount;

    private BigDecimal payAmount;

    private Integer payType;

    private String deliverySn;

    private String receiverName;

    private String receiverPhone;

    private String receiverPostCode;

    private String receiverProvince;

    private String receiverCity;

    private String receiverRegion;

    private String receiverDetailAddress;

    private Integer confirmStatus;

    private Integer deleteStatus;

    private LocalDateTime paymentTime;

    private LocalDateTime deliveryTime;

    private LocalDateTime receiveTime;

    private LocalDateTime commentTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
