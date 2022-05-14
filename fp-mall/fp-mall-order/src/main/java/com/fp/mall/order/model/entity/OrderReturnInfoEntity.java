package com.fp.mall.order.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@TableName("order_return_info")
public class OrderReturnInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long userId;

    private Long skuId;

    private String skuName;

    private String skuBrand;

    private String skuAttrs;

    private String skuImgUrl;

    private BigDecimal skuPrice;

    private BigDecimal realPrice;

    private String returnReason;

    private String returnReasonImgsUrl;

    private Integer returnCount;

    private BigDecimal returnAmount;

    private Boolean returnStatus;

    private String handlePerson;

    private String handleNote;

    private LocalDateTime handleTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
