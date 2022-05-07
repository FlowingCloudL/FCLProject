package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.SkuSaleAttrMapper;
import com.fp.mall.product.model.dto.SkuSaleAttrDTO;
import com.fp.mall.product.model.entity.SkuSaleAttrEntity;
import com.fp.mall.product.model.vo.SkuSaleAttrVO;
import com.fp.mall.product.service.SkuSaleAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SkuSaleAttrServiceImpl implements SkuSaleAttrService {

    @Resource
    private SkuSaleAttrMapper skuSaleAttrMapper;

    @Override
    public List<SkuSaleAttrVO> listBySkuId(Long skuId) {
        List<SkuSaleAttrEntity> entityList = skuSaleAttrMapper.listBySkuId(skuId);
        return convertToSkuSaleAttrVO(entityList);
    }

    @Override
    public List<SkuSaleAttrVO> listByAttrId(Long attrId) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public void saveBatch(Long skuId, List<SkuSaleAttrDTO> skuSaleAttrDTOList) {
        List<SkuSaleAttrEntity> entityList = convertToSkuSaleAttrEntity(skuSaleAttrDTOList);
        skuSaleAttrMapper.saveBatch(skuId, entityList);
    }

    @Override
    public void updateBatch(Long skuId, List<SkuSaleAttrDTO> skuSaleAttrDTOList) {
        List<SkuSaleAttrEntity> entityList = convertToSkuSaleAttrEntity(skuSaleAttrDTOList);
        skuSaleAttrMapper.updateBatch(skuId, entityList);
    }

    @Override
    public void deleteById(Long id) {
        skuSaleAttrMapper.deleteById(id);
    }

    @Override
    public void deleteBySkuId(Long skuId) {
        skuSaleAttrMapper.deleteBySkuId(skuId);
    }

    @Override
    public void deleteBySpuId(Long spuId) {
        skuSaleAttrMapper.deleteBySpuId(spuId);
    }

    //================================================== 辅助方法 ==================================================

    private SkuSaleAttrVO convertToSkuSaleAttrVO(SkuSaleAttrEntity entity) {
        SkuSaleAttrVO vo = new SkuSaleAttrVO();
        vo.setId(entity.getId());
        vo.setSkuId(entity.getSkuId());
        vo.setAttrId(entity.getAttrId());
        vo.setAttrName(entity.getAttrName());
        vo.setAttrValue(entity.getAttrValue());
        vo.setCreateTime(entity.getCreateTime());
        vo.setUpdateTime(entity.getUpdateTime());
        return vo;
    }

    private List<SkuSaleAttrVO> convertToSkuSaleAttrVO(List<SkuSaleAttrEntity> entityList) {
        List<SkuSaleAttrVO> voList = new ArrayList<>(entityList.size());
        for (SkuSaleAttrEntity entity : entityList) {
            voList.add(convertToSkuSaleAttrVO(entity));
        }
        return voList;
    }

    private SkuSaleAttrEntity convertToSkuSaleAttrEntity(SkuSaleAttrDTO dto) {
        SkuSaleAttrEntity entity = new SkuSaleAttrEntity();
        entity.setId(dto.getId());
        entity.setAttrId(dto.getAttrId());
        entity.setAttrName(dto.getAttrName());
        entity.setAttrValue(dto.getAttrValue());
        return entity;
    }

    private List<SkuSaleAttrEntity> convertToSkuSaleAttrEntity(List<SkuSaleAttrDTO> dtoList) {
        List<SkuSaleAttrEntity> entityList = new ArrayList<>(dtoList.size());
        for (SkuSaleAttrDTO dto : dtoList) {
            entityList.add(convertToSkuSaleAttrEntity(dto));
        }
        return entityList;
    }
}
