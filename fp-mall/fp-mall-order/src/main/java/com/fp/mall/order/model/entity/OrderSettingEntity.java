package com.fp.mall.order.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@TableName("order_setting")
public class OrderSettingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer flashOrderOvertime;

    private Integer normalOrderOvertime;

    @ApiModelProperty("发货后自动确认收货时间（天）")
    private Integer confirmOvertime;

    private Integer finishOvertime;

    private Integer commentOvertime;


}
