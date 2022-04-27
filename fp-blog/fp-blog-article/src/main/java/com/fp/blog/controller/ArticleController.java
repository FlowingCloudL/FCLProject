package com.fp.blog.controller;

import com.fp.blog.dto.ArticleListVO;
import com.fp.blog.dto.ResponseDTO;
import com.fp.blog.entity.ArticleEntity;
import com.fp.blog.entity.CategoryEntity;
import com.fp.blog.entity.TagEntity;
import com.fp.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController()
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/query/{id}")
    public ResponseDTO queryByArticleID(@RequestBody @PathVariable("id") @NotNull Integer id) {

        ArticleEntity blogArticleEntity = articleService.queryByArticleID(id);
        return ResponseDTO.getSuccess("ok", blogArticleEntity);

    }

    @RequestMapping("/modify")
    public ResponseDTO modifyArticle(@RequestBody @Validated ArticleEntity article){

        boolean res = articleService.modifyArticle(article);
        return res ? ResponseDTO.getSuccess() : ResponseDTO.getError();

    }

    @RequestMapping("/publish")
    public ResponseDTO publishArticle(@RequestBody @Validated ArticleEntity article){

        boolean res = articleService.publishArticle(article);
        return res ? ResponseDTO.getSuccess() : ResponseDTO.getError();

    }

    @RequestMapping("/delete/{id}")
    public ResponseDTO deleteArticle(@RequestBody @PathVariable("id") @NotNull Integer id){

        boolean res = articleService.deleteArticle(id);
        return res ? ResponseDTO.getSuccess() : ResponseDTO.getError();

    }

    @GetMapping("/list")
    public ResponseDTO getArticleList() {
        List<ArticleListVO> articleList = articleService.getArticleList();
        return ResponseDTO.getSuccess("查询成功", articleList);
    }

    @GetMapping("/category")
    public ResponseDTO getCategoryList() {
        List<CategoryEntity> categoryList = articleService.getCategoryList();
        return ResponseDTO.getSuccess("查询成功", categoryList);
    }

    @GetMapping("/category/{id}")
    public ResponseDTO getCategoryById(@RequestBody @PathVariable("id") Integer id) {
        String name = articleService.getCategoryNameById(id);
        return ResponseDTO.getSuccess("查询成功", name);
    }

    @GetMapping("/tag")
    public ResponseDTO getTagList() {
        List<TagEntity> tagList = articleService.getTagList();
        return ResponseDTO.getSuccess("查询成功", tagList);
    }

    @GetMapping("/tag/{id}")
    public ResponseDTO getTagById(@RequestBody @PathVariable("id") Integer id) {
        String name = articleService.getTagNameById(id);
        return ResponseDTO.getSuccess("查询成功", name);
    }

}
