package com.fp.mall.product.service.impl;

import com.fp.mall.product.consts.ProductStatusConst;
import com.fp.mall.product.mapper.SpuMapper;
import com.fp.mall.product.model.dto.SpuDTO;
import com.fp.mall.product.model.entity.SpuEntity;
import com.fp.mall.product.model.vo.SkuVO;
import com.fp.mall.product.model.vo.SpuAppSearchVO;
import com.fp.mall.product.model.vo.SpuVO;
import com.fp.mall.product.service.SkuService;
import com.fp.mall.product.service.SpuBasicAttrService;
import com.fp.mall.product.service.SpuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private SpuBasicAttrService spuBasicAttrService;

    @Resource
    private SkuService skuService;

    @Override
    public List<SpuVO> listSpuBySpuIds(List<Long> spuIds) {
        List<SpuEntity> entityList = spuMapper.listBySpuIds(spuIds);
        List<SpuVO> voList = new ArrayList<>(entityList.size());
        for (SpuEntity entity : entityList) {
            SpuVO spuVO = new SpuVO();
            BeanUtils.copyProperties(entity, spuVO);
            voList.add(spuVO);
        }
        return voList;
    }

    @Override
    public SpuVO getSpuBySpuId(Long spuId) {
        return convertToSpuVO(spuMapper.getBySpuId(spuId));
    }

    @Override
    public List<Long> getSpuIdsByCategoryAndBrand(List<Long> categoryIds, Long brandId) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public void saveSpu(SpuDTO spuDTO) {
        // 保存spu信息
        spuMapper.save(convertToSpuEntity(spuDTO));
        // 保存与之关联的基本属性
        spuBasicAttrService.saveBatch(spuDTO.getSpuId(), spuDTO.getSpuBasicAttrs());
    }

    @Override
    public void updateSpu(SpuDTO spuDTO) {
        // 更新基本信息
        spuMapper.update(convertToSpuEntity(spuDTO));
        // 更新与之关联的基本属性
        spuBasicAttrService.saveBatch(spuDTO.getSpuId(), spuDTO.getSpuBasicAttrs());
    }

    @Override
    public void onTheShelf(List<Long> spuIds) {
        spuMapper.changeStatusBatch(spuIds, ProductStatusConst.ON_THE_SHELF);
    }

    @Override
    public void offTheShelf(List<Long> spuIds) {
        spuMapper.changeStatusBatch(spuIds, ProductStatusConst.OFF_THE_SHELF);
    }

    @Transactional
    @Override
    public void deleteSpuBySpuId(Long spuId) {
        spuMapper.deleteBySpuId(spuId);
        spuBasicAttrService.deleteBySpuId(spuId);
        skuService.deleteBySpuId(spuId);
    }

    @Override
    public void clearSpuCacheBySpuId(Long spuId) {
        throw new RuntimeException("方法未定义");
    }

    @Override
    public void batchClearSpuCacheBySpuIds(List<Long> spuIds) {
        throw new RuntimeException("方法未定义");
    }

    //================================================== 辅助方法 ==================================================

    private SpuVO convertToSpuVO(SpuEntity spuEntity) {
        // 设置基本属性
        SpuVO spuVO = new SpuVO();
        spuVO.setSpuId(spuEntity.getSpuId());
        spuVO.setSpuName(spuEntity.getSpuName());
        spuVO.setSpuDesc(spuEntity.getSpuDesc());
        spuVO.setDescImgUrl(spuEntity.getDescImgUrl());
        spuVO.setBrandId(spuEntity.getBrandId());
        spuVO.setCategoryId(spuEntity.getCategoryId());
        spuVO.setStatus(spuEntity.getStatus());
        spuVO.setCreateTime(spuEntity.getCreateTime());
        spuVO.setUpdateTime(spuEntity.getUpdateTime());
        // 设置复杂属性
        List<SkuVO> skuVOList = skuService.listBySpuId(spuEntity.getSpuId());
        spuVO.setSkus(skuVOList);

        return spuVO;
    }

    private SpuEntity convertToSpuEntity(SpuDTO spuDTO) {
        SpuEntity spuEntity = new SpuEntity();
        spuEntity.setSpuId(spuDTO.getSpuId());
        spuEntity.setSpuName(spuDTO.getSpuName());
        spuEntity.setSpuDesc(spuDTO.getSpuDesc());
        spuEntity.setDescImgUrl(spuDTO.getDescImgUrl());
        spuEntity.setBrandId(spuDTO.getBrandId());
        spuEntity.setCategoryId(spuDTO.getCategoryId());
        spuEntity.setStatus(spuDTO.getStatus());
        return spuEntity;
    }
}
