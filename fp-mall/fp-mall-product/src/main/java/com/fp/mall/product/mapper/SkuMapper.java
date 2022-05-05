package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.SkuDTO;
import com.fp.mall.product.model.entity.SkuEntity;
import com.fp.mall.product.model.vo.SkuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author FlowingCloudL
 * @date 2022/4/27 21:21
 */
@Mapper
public interface SkuMapper {

    /**
     * 根据skuId获取sku信息
     * @param skuId 库存id
     * @return sku信息
     */
    SkuEntity getBySkuId(@Param("skuId") Long skuId);

    /**
     * 根据spuId, 获取sku列表（可指定状态, status为null时表示所有状态都可以）
     * @param spuId 商品id
     * @return sku列表
     */
    List<SkuEntity> listBySpuId(@Param("spuId") Long spuId, @Param("status") Byte status);

    /**
     * 保存sku信息
     * @param sku sku信息
     */
    void save(@Param("sku") SkuEntity sku);

    /**
     * 批量保存sku信息
     * @param skuList sku信息列表
     */
    void saveBatch(@Param("skuList") List<SkuDTO> skuList);

    /**
     * 更新sku信息
     * @param sku sku信息
     */
    void update(@Param("sku") SkuEntity sku);

    /**
     * 批量更新sku信息
     * @param skuList 修改后的sku信息列表
     */
    void updateBatch(@Param("skuList") List<SkuEntity> skuList);

    /**
     * 增加销量
     * @param id 库存id
     * @param num 增加值
     */
    void addSales(@Param("id") Long id, @Param("num") Integer num);

    /**
     * 修改库存量 (正数为增加, 负数为减少)
     * @param id 库存id
     * @param num 修改值
     */
    void changeStock(@Param("id") Long id, @Param("num") Integer num);

    /**
     * 删除sku信息
     * @param skuId 库存id
     */
    void deleteBySkuId(@Param("skuId") Long skuId);

    /**
     * 删除sku信息
     * @param spuId 商品id
     */
    void deleteBySpuId(@Param("spuId") Long spuId);


}
