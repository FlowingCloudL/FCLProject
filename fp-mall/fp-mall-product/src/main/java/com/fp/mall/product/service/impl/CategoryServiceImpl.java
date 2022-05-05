package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.CategoryMapper;
import com.fp.mall.product.model.dto.CategoryDTO;
import com.fp.mall.product.model.entity.CategoryEntity;
import com.fp.mall.product.model.vo.CategoryVO;
import com.fp.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> listCategories() {
        return listCategoriesByParentId(0L);
    }

    @Override
    public List<CategoryVO> listCategoriesByParentId(Long parentId) {
        List<CategoryEntity> categoryEntityList = categoryMapper.listByParentId(parentId);
        return convertToCategoryVOList(categoryEntityList);
    }

    @Override
    public List<Long> listCategoryIdsByParentId(Long parentId) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public List<CategoryVO> listCategoriesByCategoryIds(List<Long> categoryIds) {
        List<CategoryEntity> categoryEntityList = categoryMapper.listByIds(categoryIds);
        return convertToCategoryVOList(categoryEntityList);
    }

    @Override
    public CategoryVO getCategoryByCategoryId(Long id) {
        CategoryEntity categoryEntity = categoryMapper.getById(id);
        return convertToCategoryVO(categoryEntity);
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryMapper.save(convertToCategoryEntity(categoryDTO));
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        categoryMapper.update(convertToCategoryEntity(categoryDTO));
    }

    @Override
    public void deleteByCategoryId(Long id) {
        categoryMapper.deleteById(id);
    }

    //======================================================= 辅助方法 =======================================================

    private CategoryVO convertToCategoryVO(CategoryEntity categoryEntity) {
        CategoryVO categoryVO = new CategoryVO();
        // 设置基本属性
        categoryVO.setId(categoryEntity.getId());
        categoryVO.setName(categoryEntity.getName());
        categoryVO.setDesc(categoryEntity.getDesc());
        categoryVO.setParentId(categoryEntity.getParentId());
        categoryVO.setLevel(categoryEntity.getLevel());
        categoryVO.setIconUrl(categoryEntity.getIconUrl());
        categoryVO.setStatus(categoryEntity.getStatus());
        categoryVO.setCreateTime(categoryEntity.getCreateTime());
        categoryVO.setUpdateTime(categoryEntity.getUpdateTime());
        // 设置子分类VO
        setChildCategories(categoryVO);
        return categoryVO;
    }

    private List<CategoryVO> convertToCategoryVOList(List<CategoryEntity> categoryEntityList) {
        List<CategoryVO> voList = new ArrayList<>(categoryEntityList.size());
        for (CategoryEntity categoryEntity : categoryEntityList) {
            voList.add(convertToCategoryVO(categoryEntity));
        }
        return voList;
    }

    private void setChildCategories(CategoryVO categoryVO) {
        List<CategoryVO> categoryVOs = listCategoriesByParentId(categoryVO.getId());
        for (CategoryVO vo : categoryVOs) {
            setChildCategories(vo);
        }
        categoryVO.setCategories(categoryVOs);
    }

    private CategoryEntity convertToCategoryEntity(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setDesc(categoryDTO.getDesc());
        categoryEntity.setParentId(categoryDTO.getParentId());
        categoryEntity.setLevel(categoryDTO.getLevel());
        categoryEntity.setStatus(categoryDTO.getStatus());
        return categoryEntity;
    }

}
