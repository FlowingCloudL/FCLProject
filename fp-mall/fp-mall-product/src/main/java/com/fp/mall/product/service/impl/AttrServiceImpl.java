package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.AttrMapper;
import com.fp.mall.product.mapper.AttrValueMapper;
import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.dto.AttrValueDTO;
import com.fp.mall.product.model.entity.AttrEntity;
import com.fp.mall.product.model.entity.AttrValueEntity;
import com.fp.mall.product.model.vo.AttrVO;
import com.fp.mall.product.model.vo.AttrValueVO;
import com.fp.mall.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrMapper attrMapper;

    @Autowired
    private AttrValueMapper attrValueMapper;

    @Override
    public AttrVO getAttrByAttrId(Long attrId) {
        AttrEntity attrEntity = attrMapper.getById(attrId);
        return buildAttrVO(attrEntity);
    }

    @Override
    public List<AttrVO> listAttrsByCategoryId(Long categoryId) {
        List<AttrEntity> attrEntityList = attrMapper.listByCategoryId(categoryId);
        return buildAttrVOList(attrEntityList);
    }

    @Override
    public void saveAttr(AttrDTO attr) {
        attr.setId(null);
        attrMapper.save(buildAttrEntity(attr));
        attrValueMapper.saveBatch(buildAttrValueEntityList(attr.getAttrValues()));
    }

    @Override
    public void updateAttr(AttrDTO attr) {
        attrMapper.update(buildAttrEntity(attr));
        attrValueMapper.updateBatch(buildAttrValueEntityList(attr.getAttrValues()));
    }

    @Override
    public void deleteAttrByAttrId(Long attrId) {
        attrMapper.deleteById(attrId);
        attrValueMapper.deleteByAttrId(attrId);
    }

    @Override
    public void removeAttrCacheByCategoryId(List<Long> categoryIds) {
        throw new RuntimeException("方法未定义");
    }

    //=============================================== 辅助方法 ===============================================

    private AttrVO buildAttrVO (AttrEntity attrEntity) {
        // 构造VO
        AttrVO attrVO = new AttrVO();
        // Entity -> VO
        attrVO.setId(attrEntity.getId());
        attrVO.setCategoryId(attrEntity.getCategoryId());
        attrVO.setName(attrEntity.getName());
        attrVO.setDesc(attrEntity.getDesc());
        attrVO.setType(attrEntity.getType());
        attrVO.setSearchable(attrEntity.getSearchable());
        // 查询属性值并填充到VO的attrValues中
        List<AttrValueEntity> attrValueEntityList = attrValueMapper.listByAttrId(attrEntity.getId()); // 待转换Entity
        List<AttrValueVO> attrValues = new ArrayList<>(attrValueEntityList.size());
        for (AttrValueEntity attrValueEntity : attrValueEntityList) {
            attrValues.add(buildAttrValueVO(attrValueEntity)); // VO -> Entity
        }
        attrVO.setAttrValues(attrValues); // 设置attrValues
        return attrVO;
    }

    private List<AttrVO> buildAttrVOList (List<AttrEntity> attrEntityList) {
        List<AttrVO> attrVOList = new ArrayList<>(attrEntityList.size());
        for (AttrEntity attrEntity : attrEntityList) {
            attrVOList.add(buildAttrVO(attrEntity)); // VO -> Entity
        }
        return attrVOList;
    }

    private AttrValueVO buildAttrValueVO (AttrValueEntity attrValueEntity) {
        AttrValueVO attrValueVO = new AttrValueVO();
        attrValueVO.setId(attrValueEntity.getId());
        attrValueVO.setAttrId(attrValueEntity.getAttrId());
        attrValueVO.setValue(attrValueEntity.getValue());
        return attrValueVO;
    }

    private AttrEntity buildAttrEntity(AttrDTO attrDTO) {
        AttrEntity attrEntity = new AttrEntity();
        attrEntity.setName(attrDTO.getName());
        attrEntity.setCategoryId(attrEntity.getCategoryId());
        attrEntity.setDesc(attrDTO.getDesc());
        attrEntity.setType(attrEntity.getType());
        attrEntity.setSearchable(attrEntity.getSearchable());
        return attrEntity;
    }

    private AttrValueEntity buildAttrValueEntity(AttrValueDTO attrValueDTO) {
        AttrValueEntity attrValueEntity = new AttrValueEntity();
        attrValueEntity.setAttrId(attrValueDTO.getAttrId());
        attrValueEntity.setValue(attrValueDTO.getValue());
        return attrValueEntity;
    }

    private List<AttrValueEntity> buildAttrValueEntityList(List<AttrValueDTO> dtoList) {
        List<AttrValueEntity> attrValueEntityList = new ArrayList<>(dtoList.size());
        for (AttrValueDTO dto : dtoList) {
            attrValueEntityList.add(buildAttrValueEntity(dto));
        }
        return attrValueEntityList;
    }
}
