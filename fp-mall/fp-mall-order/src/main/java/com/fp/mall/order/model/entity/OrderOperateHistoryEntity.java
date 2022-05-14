package com.fp.mall.order.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单操作历史记录
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@TableName("order_operate_history")
public class OrderOperateHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "operate_id", type = IdType.AUTO)
    private Long operateId;

    private Long orderId;

    private Integer orderStatus;

    private String operatePerson;

    private String operateNote;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
