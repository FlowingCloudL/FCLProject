package com.fp.mall.pay.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("mall_account")
public class AccountEntity {

    @TableId
    private Integer uid;
    private Integer balance;

}
