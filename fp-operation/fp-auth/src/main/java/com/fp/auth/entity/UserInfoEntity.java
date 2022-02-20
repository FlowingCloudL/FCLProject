package com.fp.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

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
