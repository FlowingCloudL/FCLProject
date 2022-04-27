package com.fp.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("blog_article")
@Data
public class ArticleEntity {

    private Integer articleId;
    private Integer uid;
    private String title;
    private String content;
    private Date publishTime;
    private Date modifyTime;
    private Integer views;

}
