package com.fp.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_security")
public class UserSecurityEntity {

    @TableId
    private Integer lid;
    private String identity;
    private String credentials;
    private String role;
    private String authority;
    private Date registerDatetime;
    private Date lastLoginDatetime;
    private Integer lastLoginIp;
}
