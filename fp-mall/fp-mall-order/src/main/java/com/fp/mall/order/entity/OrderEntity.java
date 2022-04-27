package com.fp.mall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("mall_order")
public class OrderEntity {

    @TableId(type = IdType.AUTO)
    private Integer orderId;
    private Integer itemId;
    private Integer itemNum;
    private Integer uid;
    private Integer orderAmount;

}
