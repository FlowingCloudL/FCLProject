package com.fp.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("auth_sso")
public class UserAuthEntity {

    @TableId
    private Integer tid;
    private String identity;
    private String credentials;
    private Integer uid;
    private Date registerDatetime;
    private Date lastLoginDatetime;
    private Integer lastLoginIp;
}
