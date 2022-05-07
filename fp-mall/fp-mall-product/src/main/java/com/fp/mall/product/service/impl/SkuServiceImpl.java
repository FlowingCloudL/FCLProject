package com.fp.mall.product.service.impl;

import com.fp.mall.product.mapper.SkuMapper;
import com.fp.mall.product.model.dto.SkuDTO;
import com.fp.mall.product.model.entity.SkuEntity;
import com.fp.mall.product.model.vo.SkuSaleAttrVO;
import com.fp.mall.product.model.vo.SkuVO;
import com.fp.mall.product.service.SkuSaleAttrService;
import com.fp.mall.product.service.SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuSaleAttrService skuSaleAttrService;

    @Override
    public SkuVO getBySkuId(Long skuId) {
        SkuEntity skuEntity = skuMapper.getBySkuId(skuId);
        return convertToSkuVO(skuEntity);
    }

    @Override
    public List<SkuVO> listBySpuId(Long spuId) {
        List<SkuEntity> entityList = skuMapper.listBySpuId(spuId, null);
        return convertToSkuVO(entityList);
    }

    @Override
    public void save(SkuDTO skuDTO) {
        skuMapper.save(convertToSkuEntity(skuDTO));
        skuSaleAttrService.saveBatch(skuDTO.getSkuId(), skuDTO.getSkuSaleAttrs());
    }

    @Override
    public void update(SkuDTO skuDTO) {
        skuMapper.update(convertToSkuEntity(skuDTO));
        // 删除旧的销售属性
        skuSaleAttrService.deleteBySkuId(skuDTO.getSkuId());
        // 保存新的销售属性
        skuSaleAttrService.saveBatch(skuDTO.getSkuId(), skuDTO.getSkuSaleAttrs());
    }

    @Override
    public void changeStatus(List<Long> skuIds, Byte status) {
        skuMapper.changeStatus(skuIds, status);
    }

    @Override
    public void deleteBySkuId(Long skuId) {
        skuMapper.deleteBySkuId(skuId);
        skuSaleAttrService.deleteBySkuId(skuId);
    }

    @Override
    public void deleteBySpuId(Long spuId) {
        skuMapper.deleteBySpuId(spuId);
        skuSaleAttrService.deleteBySpuId(spuId);
    }

    @Override
    public void clearSkuCacheBySpuIdOrSkuIds(Long spuId, List<Long> skuIds) {
        throw new RuntimeException("方法未定义");
    }

    //================================================== 辅助方法 ==================================================

    private SkuVO convertToSkuVO(SkuEntity entity) {
        SkuVO vo = new SkuVO();
        // 设置基本
        vo.setSkuId(entity.getSkuId());
        vo.setSkuName(entity.getSkuName());
        vo.setSkuDesc(entity.getSkuDesc());
        vo.setSpuId(entity.getSpuId());
        vo.setPrice(entity.getPrice());
        vo.setStock(entity.getStock());
        vo.setSales(entity.getSales());
        vo.setStatus(entity.getStatus());
        // 设置销售属性
        List<SkuSaleAttrVO> voList = skuSaleAttrService.listBySkuId(entity.getSkuId());
        vo.setSkuSaleAttrLst(voList);
        return vo;
    }

    private List<SkuVO> convertToSkuVO(List<SkuEntity> entityList) {
        List<SkuVO> voList = new ArrayList<>(entityList.size());
        for (SkuEntity entity : entityList) {
            voList.add(convertToSkuVO(entity));
        }
        return voList;
    }

    private SkuEntity convertToSkuEntity(SkuDTO dto) {
        SkuEntity entity = new SkuEntity();
        entity.setSkuId(dto.getSkuId());
        entity.setSpuId(dto.getSpuId());
        entity.setSkuName(dto.getSkuName());
        entity.setSkuDesc(dto.getSkuDesc());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
        entity.setSales(dto.getSales());
        entity.setStatus(dto.getStatus());
        return entity;
    }

}
