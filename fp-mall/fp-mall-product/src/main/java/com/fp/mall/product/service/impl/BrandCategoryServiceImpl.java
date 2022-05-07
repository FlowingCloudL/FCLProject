package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.BrandCategoryMapper;
import com.fp.mall.product.model.entity.BrandCategoryEntity;
import com.fp.mall.product.service.BrandCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandCategoryServiceImpl implements BrandCategoryService {

    @Resource
    private BrandCategoryMapper brandCategoryMapper;

    public List<Long> listCategoryIdsByBrandId(Long brandId) {
        return brandCategoryMapper.listCategoryIdsByBrandId(brandId);
    }

    public List<Long> listBrandIdsByCategoryId(Long categoryId) {
        return brandCategoryMapper.listBrandIdsByCategoryId(categoryId);
    }

    @Override
    @Transactional
    public void saveBrandToCategory(Long brandId, List<Long> categoryIds) {
        List<BrandCategoryEntity> entityList = new ArrayList<>(categoryIds.size());
        for (Long categoryId : categoryIds) {
            BrandCategoryEntity brandCategoryEntity = new BrandCategoryEntity();
            brandCategoryEntity.setBrandId(brandId);
            brandCategoryEntity.setCategoryId(categoryId);
            entityList.add(brandCategoryEntity);
        }
        brandCategoryMapper.saveBatch(entityList);
    }

    @Override
    @Transactional
    public void updateBrandToCategory(Long brandId, List<Long> categoryIds) {
        // 清空已存在的关联
        brandCategoryMapper.deleteByBrandId(brandId);
        // 设置新关联
        saveBrandToCategory(brandId, categoryIds);
    }

    @Override
    public void deleteByBrandId(Long brandId) {
        brandCategoryMapper.deleteByBrandId(brandId);
    }

    @Override
    public void deleteBrandToCategory(Long brandId, List<Long> categoryIds) {
        brandCategoryMapper.deleteBrandIdToCategoryIds(brandId, categoryIds);
    }

    @Override
    public void deleteCategoryToBrand(Long categoryId, List<Long> brandIds) {
        brandCategoryMapper.deleteCategoryIdToBrandIds(categoryId, brandIds);
    }
}
