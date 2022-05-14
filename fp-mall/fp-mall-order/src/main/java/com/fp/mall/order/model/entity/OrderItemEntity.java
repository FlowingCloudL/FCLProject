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
@TableName("order_item")
public class OrderItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long spuId;

    private String spuName;

    private String spuImgUrl;

    private String brandId;

    private Long categoryId;

    private Long skuId;

    private String skuName;

    private String skuImgUrl;

    private String skuAttrs;

    private Integer skuQuantity;

    private BigDecimal skuPrice;

    private BigDecimal discountAmount;

    private BigDecimal realAmount;


}
