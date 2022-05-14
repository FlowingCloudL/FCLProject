package com.fp.mall.order.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单操作历史记录
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@ApiModel("订单操作历史记录DTO")
public class OrderOperateHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("操作记录id")
    private Long operateId;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("操作后的订单状态 [0:待付款；1:待发货；2:已发货；3:已完成；4:已关闭；5:无效订单]")
    private Integer orderStatus;

    @ApiModelProperty("操作人 [0:用户；1:系统；2:后台管理员]")
    private String operatePerson;

    @ApiModelProperty("操作备注")
    private String operateNote;


}
