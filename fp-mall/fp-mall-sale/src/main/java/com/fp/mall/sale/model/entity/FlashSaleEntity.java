package com.fp.mall.sale.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sms_flashsale")
public class FlashSaleEntity {

    @TableId
    private Long flashsaleId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Byte status;
    private LocalDateTime createTime;
    private Long createUserId;

}
