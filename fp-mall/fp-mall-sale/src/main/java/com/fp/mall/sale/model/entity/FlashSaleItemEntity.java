package com.fp.mall.sale.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sms_flashsale_item")
public class FlashSaleItemEntity {

    @TableId("flashsale_item_id")
    private Long flashsaleItemId;
    private Long skuId;
    private Long flashsaleSessionId;
    private Double price;
    private Integer stock;
    private Integer limit;
    private Byte status;

}
