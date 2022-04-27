package com.fp.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.blog.dto.ArticleListVO;
import com.fp.blog.dto.PageVO;
import com.fp.blog.entity.ArticleEntity;
import com.fp.blog.entity.CategoryEntity;
import com.fp.blog.entity.TagEntity;
import com.fp.blog.mapper.ArticleMapper;
import com.fp.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    private PageVO<ArticleEntity> queryByPage(Integer pageNum, Integer pageSize, QueryWrapper queryWrapper) {
        Page<ArticleEntity> article = articleMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        PageVO<ArticleEntity> vo = new PageVO<>();
        vo.setPageNum(pageNum);
        vo.setPageSize(pageSize);
        vo.setTotal(article.getTotal());
        vo.setDataList(article.getRecords());
        return vo;
    }

    @Override
    public ArticleEntity queryByArticleID(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public PageVO<ArticleEntity> queryByAuthorUid(Integer authorUid, Integer pageNum, Integer pageSize) {
        QueryWrapper<ArticleEntity> queryWrapper = new QueryWrapper<ArticleEntity>().eq("author_uid", authorUid);
        return queryByPage(pageNum, pageSize, queryWrapper);
    }

    @Override
    public boolean modifyArticle(ArticleEntity article) {
        int result = articleMapper.updateById(article);
        return result > 0;
    }

    @Override
    public boolean publishArticle(ArticleEntity article) {
        int result = articleMapper.insert(article);
        return result > 0;
    }

    @Override
    public boolean deleteArticle(Integer id) {
        int result = articleMapper.deleteById(id);
        return result > 0;
    }

    @Override
    public List<ArticleListVO> getArticleList() {
        return articleMapper.getArticleList();
    }

    @Override
    public Integer getArticleCategoryId() {
        return articleMapper.getArticleCategoryId();
    }

    @Override
    public List<CategoryEntity> getCategoryList() {
        return articleMapper.getCategoryList();
    }

    @Override
    public String getCategoryNameById(Integer id) {
        return articleMapper.getCategoryNameById(id);
    }

    @Override
    public List<Integer> getArticleTagId() {
        return articleMapper.getArticleTagId();
    }

    @Override
    public List<TagEntity> getTagList() {
        return articleMapper.getTagList();
    }

    @Override
    public String getTagNameById(Integer id) {
        return articleMapper.getTagNameById(id);
    }

}
