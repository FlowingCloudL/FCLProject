package com.fp.mall.sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.sale.model.entity.FlashSaleItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FlashSaleItemMapper extends BaseMapper<FlashSaleItemEntity> {

    List<FlashSaleItemEntity> listByFlashsaleSessionId(@Param("id") Long flashsaleSessionId);

}
