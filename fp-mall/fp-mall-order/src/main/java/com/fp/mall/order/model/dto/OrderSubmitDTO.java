package com.fp.mall.order.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author FlowingCloudL
 * @since 2022-05-10
 */
@Data
@ApiModel("订单提交DTO")
public class OrderSubmitDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("选购的SKU列表")
    private List<OrderSubmitSkuDTO> skus;

    //=================================================================

    @ApiModelProperty("订单来源 [0:PC订单；1:app订单]")
    private Integer orderSource;

    @ApiModelProperty("订单备注")
    private String orderNote;

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

}
