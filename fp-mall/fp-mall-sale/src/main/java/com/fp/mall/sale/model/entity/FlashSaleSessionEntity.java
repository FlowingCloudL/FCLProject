package com.fp.mall.sale.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalTime;

@Data
@TableName("sms_flashsale_session")
public class FlashSaleSessionEntity {

    @TableId
    private Long flashsaleSessionId;

    private Long flashsaleId;

    private LocalTime startTime;

    private LocalTime endTime;

    private Byte status;

}
