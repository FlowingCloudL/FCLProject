package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.entity.SpuEntity;
import com.fp.mall.product.model.vo.SpuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuMapper {

    /**
     * 获取spu列表 (动态sql)
     * @param spuSearchDTO spu搜索信息
     * @return spu列表
     */
    List<SpuEntity> list(@Param("spuDTO") SpuSearchDTO spuSearchDTO);

    /**
     * 获取spuId列表 (动态sql)
     * @param spuSearchDTO spu搜索信息
     * @return spuId列表
     */
    List<Long> listSpuIds(@Param("spuDTO") SpuSearchDTO spuSearchDTO);

    /**
     * 根据spu信息id获取spu信息
     * @param spuId spu信息id
     * @return spu信息
     */
    SpuEntity getBySpuId(@Param("spuId") Long spuId);

    /**
     * 保存spu信息
     * @param spu spu实体类
     */
    void save(@Param("spu") SpuEntity spu);

    /**
     * 更新spu信息
     * @param spu spu实体类
     */
    void update(@Param("spu") SpuEntity spu);

    /**
     * 修改商品状态（上下架）
     * @param spuId 商品id
     * @param status 目标状态
     */
    void changeStatus(@Param("spuId") Long spuId, @Param("status") Byte status);

    /**
     * 批量修改商品状态（上下架）
     * @param spuIdList 商品id列表
     * @param status 目标状态
     */
    void changeStatusBatch(@Param("spuIdList") List<Long> spuIdList, @Param("status") Byte status);

    /**
     * 删除spu信息
     * @param spuId 商品id
     */
    void deleteBySpuId(@Param("spuId") Long spuId);

}
