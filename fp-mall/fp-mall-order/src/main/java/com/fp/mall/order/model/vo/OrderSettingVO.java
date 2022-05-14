package com.fp.mall.order.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单配置信息表
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@ApiModel("订单配置信息VO")
public class OrderSettingVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("秒杀订单超时关闭时间(分)")
    private Integer flashOrderOvertime;

    @ApiModelProperty("正常订单超时时间(分)")
    private Integer normalOrderOvertime;

    @ApiModelProperty("发货后自动确认收货时间（天）")
    private Integer confirmOvertime;

    @ApiModelProperty("自动完成交易时间，不能申请退货（天）")
    private Integer finishOvertime;

    @ApiModelProperty("订单完成后自动好评时间（天）")
    private Integer commentOvertime;


}
