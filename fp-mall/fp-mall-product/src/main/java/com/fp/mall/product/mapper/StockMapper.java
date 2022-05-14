package com.fp.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper extends BaseMapper {

    /**
     * 减少库存
     * @param skuId 库存id
     * @param count 减少量（正整数）
     * @return 更新行数
     */
    int reduceStock(@Param("skuId") Long skuId, @Param("count") Integer count);

}
