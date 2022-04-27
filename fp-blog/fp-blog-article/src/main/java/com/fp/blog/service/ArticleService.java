package com.fp.blog.service;

import com.fp.blog.dto.ArticleListVO;
import com.fp.blog.dto.PageVO;
import com.fp.blog.entity.ArticleEntity;
import com.fp.blog.entity.CategoryEntity;
import com.fp.blog.entity.TagEntity;

import java.util.List;

public interface ArticleService {

    //查看
    ArticleEntity queryByArticleID(Integer id);
    PageVO<ArticleEntity> queryByAuthorUid(Integer authorUid, Integer pageNum, Integer pageSize);

    //修改
    boolean modifyArticle(ArticleEntity article);

    //发布
    boolean publishArticle(ArticleEntity article);

    //删除
    boolean deleteArticle(Integer id);

    //文章列表
    List<ArticleListVO> getArticleList();

    //分类
    Integer getArticleCategoryId();
    List<CategoryEntity> getCategoryList();
    String getCategoryNameById(Integer id);

    //标签
    List<Integer> getArticleTagId();
    List<TagEntity> getTagList();
    String getTagNameById(Integer id);

}
