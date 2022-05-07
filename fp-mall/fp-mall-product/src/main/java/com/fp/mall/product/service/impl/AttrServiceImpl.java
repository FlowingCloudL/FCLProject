package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.AttrMapper;
import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.entity.AttrEntity;
import com.fp.mall.product.model.vo.AttrVO;
import com.fp.mall.product.model.vo.SpuBasicAttrVO;
import com.fp.mall.product.service.AttrService;
import com.fp.mall.product.service.SpuBasicAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Resource
    private AttrMapper attrMapper;

    @Resource
    private SpuBasicAttrService spuBasicAttrService;

    @Override
    public AttrVO getAttrByAttrId(Long attrId) {
        AttrEntity attrEntity = attrMapper.getByAttrId(attrId);
        return buildAttrVO(attrEntity);
    }

    @Override
    public List<AttrVO> listAttrsByCategoryId(Long categoryId) {
        List<AttrEntity> attrEntityList = attrMapper.listByCategoryId(categoryId);
        return buildAttrVOList(attrEntityList);
    }

    @Override
    public void saveAttr(AttrDTO attr) {
        attrMapper.save(buildAttrEntity(attr));
    }

    @Override
    public void updateAttr(AttrDTO attr) {
        attrMapper.update(buildAttrEntity(attr));
    }

    @Override
    public void deleteAttrByAttrId(Long attrId) {
        attrMapper.deleteByAttrId(attrId);
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
        attrVO.setAttrId(attrEntity.getAttrId());
        attrVO.setAttrName(attrEntity.getAttrName());
        attrVO.setAttrType(attrEntity.getAttrType());
        attrVO.setCategoryId(attrEntity.getCategoryId());
        attrVO.setSearchable(attrEntity.getSearchable());
        attrVO.setStatus(attrEntity.getStatus());
        attrVO.setCreateTime(attrEntity.getCreateTime());
        attrVO.setUpdateTime(attrEntity.getUpdateTime());
        // 查询属性值并填充到VO的spuBasicAttrVOList中
        List<SpuBasicAttrVO> attrValueEntityList = spuBasicAttrService.listByAttrId(attrEntity.getAttrId());
        attrVO.setSpuBasicAttrVOList(attrValueEntityList);
        return attrVO;
    }

    private List<AttrVO> buildAttrVOList (List<AttrEntity> attrEntityList) {
        List<AttrVO> attrVOList = new ArrayList<>(attrEntityList.size());
        for (AttrEntity attrEntity : attrEntityList) {
            attrVOList.add(buildAttrVO(attrEntity)); // VO -> Entity
        }
        return attrVOList;
    }

    private AttrEntity buildAttrEntity(AttrDTO attrDTO) {
        AttrEntity attrEntity = new AttrEntity();
        attrEntity.setAttrId(attrDTO.getAttrId());
        attrEntity.setAttrName(attrDTO.getAttrName());
        attrEntity.setAttrType(attrDTO.getAttrType());
        attrEntity.setCategoryId(attrDTO.getCategoryId());
        attrEntity.setSearchable(attrDTO.getSearchable());
        attrEntity.setStatus(attrDTO.getStatus());
        return attrEntity;
    }
}
