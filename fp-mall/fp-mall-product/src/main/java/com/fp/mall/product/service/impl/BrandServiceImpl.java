package com.fp.mall.product.service.impl;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.mall.product.mapper.BrandMapper;
import com.fp.mall.product.model.dto.BrandDTO;
import com.fp.mall.product.model.entity.BrandEntity;
import com.fp.mall.product.model.vo.BrandVO;
import com.fp.mall.product.model.vo.CategoryVO;
import com.fp.mall.product.service.BrandCategoryService;
import com.fp.mall.product.service.BrandService;
import com.fp.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    //====================================================== Service ======================================================

    @Autowired
    private BrandCategoryService brandCategoryService;

    @Autowired
    private CategoryService categoryService;

    //====================================================== Mapper ======================================================

    @Autowired
    private BrandMapper brandMapper;

    //====================================================== 业务方法 ======================================================

    @Override
    public PageVO<BrandVO> listPage(PageDTO pageDTO, BrandDTO brandDTO) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public BrandVO getByBrandId(Long brandId) {
        return convertBrandVO(brandMapper.getById(brandId));
    }

    @Override
    public List<BrandVO> listByCategoryId(Long categoryId) {
        List<Long> brandIds = brandCategoryService.listBrandIdsByCategoryId(categoryId);
        return convertBrandVOs(brandMapper.listByIds(brandIds));
    }

    @Override
    public void save(BrandDTO brandDTO) {
        brandDTO.setId(null);
        BrandEntity brandEntity = convertBrandEntity(brandDTO);
        brandMapper.save(brandEntity);
        brandCategoryService.saveBrandToCategory(brandEntity.getId(), brandDTO.getCategoryIds());
    }

    @Override
    public void update(BrandDTO brandDTO) {
        Long id = brandDTO.getId();
        brandDTO.setId(null);
        brandMapper.update(convertBrandEntity(brandDTO));
        brandCategoryService.updateBrandToCategory(id, brandDTO.getCategoryIds());
    }

    @Override
    public void changeBrandStatus(BrandDTO brandDTO) {
        brandMapper.changeStatus(brandDTO.getId(), brandDTO.getStatus());
    }

    @Override
    @Transactional
    public void deleteByBrandId(Long brandId) {
        brandMapper.deleteById(brandId);
        brandCategoryService.deleteByBrandId(brandId);
    }
    //====================================================== 辅助方法 ======================================================

    private BrandVO convertBrandVO(BrandEntity brandEntity) {
        BrandVO brandVO = new BrandVO();
        // 设置基本属性
        brandVO.setId(brandEntity.getId());
        brandVO.setName(brandEntity.getName());
        brandVO.setDesc(brandEntity.getDesc());
        brandVO.setLogoUrl(brandEntity.getLogoUrl());
        brandVO.setSeq(brandEntity.getSeq());
        brandVO.setStatus(brandEntity.getStatus());
        brandVO.setCreateTime(brandEntity.getCreateTime());
        brandVO.setUpdateTime(brandEntity.getUpdateTime());
        // 设置分类VO列表
        setCategoryVOs(brandVO);
        return brandVO;
    }

    private List<BrandVO> convertBrandVOs(List<BrandEntity> brandEntityList) {
        List<BrandVO> brandVOs = new ArrayList<>(brandEntityList.size());
        for (BrandEntity brandEntity : brandEntityList) {
            brandVOs.add(convertBrandVO(brandEntity));
        }
        return brandVOs;
    }

    private void setCategoryVOs(BrandVO brandVO) {
        List<Long> categoryIds = brandCategoryService.listCategoryIdsByBrandId(brandVO.getId());
        List<CategoryVO> categoryVOs = categoryService.listCategoriesByCategoryIds(categoryIds);
        brandVO.setCategories(categoryVOs);
    }

    private BrandEntity convertBrandEntity(BrandDTO brandDTO) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(brandDTO.getId());
        brandEntity.setName(brandDTO.getName());
        brandEntity.setDesc(brandDTO.getDesc());
        brandEntity.setLogoUrl(brandDTO.getLogoUrl());
        brandEntity.setSeq(brandDTO.getSeq());
        brandEntity.setStatus(brandDTO.getStatus());
        return brandEntity;
    }
}
