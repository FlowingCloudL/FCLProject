package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.SpuBasicAttrMapper;
import com.fp.mall.product.model.dto.SpuBasicAttrDTO;
import com.fp.mall.product.model.entity.SpuBasicAttrEntity;
import com.fp.mall.product.model.vo.SpuBasicAttrVO;
import com.fp.mall.product.service.SpuBasicAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpuBasicAttrServiceImpl implements SpuBasicAttrService {

    @Resource
    private SpuBasicAttrMapper spuBasicAttrMapper;

    @Override
    public List<SpuBasicAttrVO> listBySpuId(Long spuId) {
        List<SpuBasicAttrEntity> entityList = spuBasicAttrMapper.listBySpuId(spuId);
        return convertToSpuBasicAttrVO(entityList);
    }

    @Override
    public List<SpuBasicAttrVO> listByAttrId(Long attrId) {
        List<SpuBasicAttrEntity> entityList = spuBasicAttrMapper.listByAttrId(attrId);
        return convertToSpuBasicAttrVO(entityList);
    }

    @Override
    public void saveBatch(Long spuId, List<SpuBasicAttrDTO> dtoList) {
        spuBasicAttrMapper.saveBatch(spuId, convertToSpuBasicAttrEntity(dtoList));
    }

    @Override
    public void updateBatch(Long spuId, List<SpuBasicAttrDTO> dtoList) {
        spuBasicAttrMapper.updateBatch(spuId, convertToSpuBasicAttrEntity(dtoList));
    }

    @Override
    public void deleteBySpuId(Long spuId) {
        spuBasicAttrMapper.deleteBySpuId(spuId);
    }

    @Override
    public void deleteByAttrId(Long attrId) {
        spuBasicAttrMapper.deleteByAttrId(attrId);
    }

    //================================================== 辅助方法 ==================================================

    private SpuBasicAttrVO convertToSpuBasicAttrVO(SpuBasicAttrEntity entity) {
        SpuBasicAttrVO vo = new SpuBasicAttrVO();
        vo.setId(entity.getId());
        vo.setSpuId(entity.getSpuId());
        vo.setAttrId(entity.getAttrId());
        vo.setAttrName(entity.getAttrName());
        vo.setAttrValue(entity.getAttrValue());
        vo.setCreateTime(entity.getCreateTime());
        vo.setUpdateTime(entity.getUpdateTime());
        return vo;
    }

    private List<SpuBasicAttrVO> convertToSpuBasicAttrVO(List<SpuBasicAttrEntity> entityList) {
        List<SpuBasicAttrVO> voList = new ArrayList<>(entityList.size());
        for (SpuBasicAttrEntity entity : entityList) {
            voList.add(convertToSpuBasicAttrVO(entity));
        }
        return voList;
    }

    private SpuBasicAttrEntity convertToSpuBasicAttrEntity(SpuBasicAttrDTO dto) {
        SpuBasicAttrEntity entity = new SpuBasicAttrEntity();
        entity.setId(dto.getId());
        entity.setAttrId(dto.getAttrId());
        entity.setAttrName(dto.getAttrName());
        entity.setAttrValue(dto.getAttrValue());
        return entity;
    }

    private List<SpuBasicAttrEntity> convertToSpuBasicAttrEntity(List<SpuBasicAttrDTO> dtoList) {
        List<SpuBasicAttrEntity> entityList = new ArrayList<>(dtoList.size());
        for (SpuBasicAttrDTO dto : dtoList) {
            entityList.add(convertToSpuBasicAttrEntity(dto));
        }
        return entityList;
    }
}
