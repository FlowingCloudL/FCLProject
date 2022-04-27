package com.fp.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.blog.dto.ArticleListVO;
import com.fp.blog.entity.ArticleEntity;
import com.fp.blog.entity.CategoryEntity;
import com.fp.blog.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    List<ArticleListVO> getArticleList();

    Integer getArticleCategoryId();
    List<CategoryEntity> getCategoryList();
    String getCategoryNameById(Integer id);

    List<Integer> getArticleTagId();
    List<TagEntity> getTagList();
    String getTagNameById(Integer id);

}
