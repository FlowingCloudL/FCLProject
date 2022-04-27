package com.fp.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("user_info")
@Data
public class UserInfoEntity {

    @TableId
    private Integer uid;
    private String nickname;
    private Integer gender;
    private Integer age;
    private Date birthday;
    private String email;

}
