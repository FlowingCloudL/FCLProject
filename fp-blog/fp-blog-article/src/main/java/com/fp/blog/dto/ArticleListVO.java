package com.fp.blog.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleListVO {

    private Integer articleId;
    private Integer uid;
    private String title;
    private Date publishTime;
    private Date modifyTime;
    private Integer views;
    private Integer category;
    private List<Integer> tag;

}
