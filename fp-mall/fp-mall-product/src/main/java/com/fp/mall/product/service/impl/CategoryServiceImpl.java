package com.fp.mall.product.service.impl;

import com.fp.mall.product.consts.ProductCacheNameConst;
import com.fp.mall.product.mapper.CategoryMapper;
import com.fp.mall.product.model.dto.CategoryDTO;
import com.fp.mall.product.model.entity.CategoryEntity;
import com.fp.mall.product.model.vo.CategoryVO;
import com.fp.mall.product.service.CategoryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Cacheable(cacheNames = ProductCacheNameConst.CATEGORY_ALL)
    @Override
    public List<CategoryVO> listCategories() {
        return listCategoriesByParentId(0L);
    }

    @Cacheable(cacheNames = ProductCacheNameConst.CATEGORY_PARENT_ID, key = "#parentId")
    @Override
    public List<CategoryVO> listCategoriesByParentId(Long parentId) {
        List<CategoryEntity> categoryEntityList = categoryMapper.listByParentId(parentId);
        return convertToCategoryVO(categoryEntityList);
    }

    @Override
    public List<Long> listCategoryIdsByParentId(Long parentId) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public List<CategoryVO> listCategoriesByCategoryIds(List<Long> categoryIds) {
        List<CategoryEntity> categoryEntityList = categoryMapper.listByCategoryIds(categoryIds);
        return convertToCategoryVO(categoryEntityList);
    }

    @Cacheable(cacheNames = ProductCacheNameConst.CATEGORY_ID, key = "#categoryId")
    @Override
    public CategoryVO getCategoryByCategoryId(Long categoryId) {
        CategoryEntity categoryEntity = categoryMapper.getByCategoryId(categoryId);
        return convertToCategoryVO(categoryEntity);
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryMapper.save(convertToCategoryEntity(categoryDTO));
    }

    @Caching(evict = {
            @CacheEvict(value = ProductCacheNameConst.CATEGORY_ALL),
            @CacheEvict(value = ProductCacheNameConst.CATEGORY_PARENT_ID, allEntries = true),
            @CacheEvict(value = ProductCacheNameConst.CATEGORY_ID, key = "#categoryDTO.categoryId")
    })
    @Override
    public void update(CategoryDTO categoryDTO) {
        categoryMapper.update(convertToCategoryEntity(categoryDTO));
    }

    @Caching(evict = {
            @CacheEvict(value = ProductCacheNameConst.CATEGORY_ALL),
            @CacheEvict(value = ProductCacheNameConst.CATEGORY_PARENT_ID, allEntries = true),
            @CacheEvict(value = ProductCacheNameConst.CATEGORY_ID, key = "#categoryId")
    })
    @Override
    public void deleteByCategoryId(Long categoryId) {
        categoryMapper.deleteByCategoryId(categoryId);
    }

    //======================================================= 辅助方法 =======================================================

    private CategoryVO convertToCategoryVO(CategoryEntity categoryEntity) {
        CategoryVO categoryVO = new CategoryVO();
        // 设置基本属性
        categoryVO.setCategoryId(categoryEntity.getCategoryId());
        categoryVO.setCategoryName(categoryEntity.getCategoryName());
        categoryVO.setCategoryLevel(categoryEntity.getCategoryLevel());
        categoryVO.setParentId(categoryEntity.getParentId());
        categoryVO.setIconUrl(categoryEntity.getIconUrl());
        categoryVO.setStatus(categoryEntity.getStatus());
        categoryVO.setCreateTime(categoryEntity.getCreateTime());
        categoryVO.setUpdateTime(categoryEntity.getUpdateTime());
        // 设置子分类VO
        setChildCategories(categoryVO);
        return categoryVO;
    }

    private List<CategoryVO> convertToCategoryVO(List<CategoryEntity> categoryEntityList) {
        List<CategoryVO> voList = new ArrayList<>(categoryEntityList.size());
        for (CategoryEntity categoryEntity : categoryEntityList) {
            voList.add(convertToCategoryVO(categoryEntity));
        }
        return voList;
    }

    private void setChildCategories(CategoryVO categoryVO) {
        List<CategoryVO> categoryVOs = listCategoriesByParentId(categoryVO.getCategoryId());
        for (CategoryVO vo : categoryVOs) {
            setChildCategories(vo);
        }
        categoryVO.setCategories(categoryVOs);
    }

    private CategoryEntity convertToCategoryEntity(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(categoryDTO.getCategoryId());
        categoryEntity.setCategoryName(categoryDTO.getCategoryName());
        categoryEntity.setCategoryLevel(categoryDTO.getCategoryLevel());
        categoryEntity.setParentId(categoryDTO.getParentId());
        categoryEntity.setIconUrl(categoryDTO.getIconUrl());
        categoryEntity.setStatus(categoryDTO.getStatus());
        return categoryEntity;
    }

}
