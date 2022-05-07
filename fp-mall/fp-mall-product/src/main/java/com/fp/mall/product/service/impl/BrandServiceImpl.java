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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    //====================================================== Service ======================================================

    @Resource
    private BrandCategoryService brandCategoryService;

    @Resource
    private CategoryService categoryService;

    //====================================================== Mapper ======================================================

    @Resource
    private BrandMapper brandMapper;

    //====================================================== 业务方法 ======================================================

    @Override
    public PageVO<BrandVO> listPage(PageDTO pageDTO, BrandDTO brandDTO) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public BrandVO getByBrandId(Long brandId) {
        return convertToBrandVO(brandMapper.getByBrandId(brandId));
    }

    @Override
    public List<BrandVO> listByCategoryId(Long categoryId) {
        List<Long> brandIds = brandCategoryService.listBrandIdsByCategoryId(categoryId);
        return convertToBrandVOs(brandMapper.listByBrandIds(brandIds));
    }

    @Override
    public void save(BrandDTO brandDTO) {
        BrandEntity brandEntity = convertToBrandEntity(brandDTO);
        brandMapper.save(brandEntity);
        brandCategoryService.saveBrandToCategory(brandEntity.getBrandId(), brandDTO.getCategoryIds());
    }

    @Override
    public void update(BrandDTO brandDTO) {
        Long id = brandDTO.getBrandId();
        brandMapper.update(convertToBrandEntity(brandDTO));
        brandCategoryService.updateBrandToCategory(id, brandDTO.getCategoryIds());
    }

    @Override
    public void changeBrandStatus(BrandDTO brandDTO) {
        brandMapper.changeStatus(brandDTO.getBrandId(), brandDTO.getStatus());
    }

    @Override
    @Transactional
    public void deleteByBrandId(Long brandId) {
        brandMapper.deleteByBrandId(brandId);
        brandCategoryService.deleteByBrandId(brandId);
    }
    //====================================================== 辅助方法 ======================================================

    private BrandVO convertToBrandVO(BrandEntity brandEntity) {
        BrandVO brandVO = new BrandVO();
        // 设置基本属性
        brandVO.setBrandId(brandEntity.getBrandId());
        brandVO.setBrandName(brandEntity.getBrandName());
        brandVO.setBrandDesc(brandEntity.getBrandDesc());
        brandVO.setLogoUrl(brandEntity.getLogoUrl());
        brandVO.setFirstLetter(brandEntity.getFirstLetter());
        brandVO.setSeq(brandEntity.getSeq());
        brandVO.setStatus(brandEntity.getStatus());
        brandVO.setCreateTime(brandEntity.getCreateTime());
        brandVO.setUpdateTime(brandEntity.getUpdateTime());
        // 设置分类VO列表
        setCategoryVOs(brandVO);
        return brandVO;
    }

    private List<BrandVO> convertToBrandVOs(List<BrandEntity> brandEntityList) {
        List<BrandVO> brandVOs = new ArrayList<>(brandEntityList.size());
        for (BrandEntity brandEntity : brandEntityList) {
            brandVOs.add(convertToBrandVO(brandEntity));
        }
        return brandVOs;
    }

    private void setCategoryVOs(BrandVO brandVO) {
        List<Long> categoryIds = brandCategoryService.listCategoryIdsByBrandId(brandVO.getBrandId());
        List<CategoryVO> categoryVOs = categoryService.listCategoriesByCategoryIds(categoryIds);
        brandVO.setCategoryVOs(categoryVOs);
    }

    private BrandEntity convertToBrandEntity(BrandDTO brandDTO) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(brandDTO.getBrandId());
        brandEntity.setBrandName(brandDTO.getBrandName());
        brandEntity.setBrandDesc(brandDTO.getBrandDesc());
        brandEntity.setLogoUrl(brandDTO.getLogoUrl());
        brandEntity.setFirstLetter(brandDTO.getFirstLetter());
        brandEntity.setSeq(brandDTO.getSeq());
        brandEntity.setStatus(brandDTO.getStatus());
        return brandEntity;
    }
}
