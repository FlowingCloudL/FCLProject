package com.fp.mall.sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.sale.model.entity.FlashSaleSessionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FlashsaleSessionMapper extends BaseMapper<FlashSaleSessionEntity> {

    List<FlashSaleSessionEntity> listByFlashsaleId(@Param("flashsaleId") Long flashsaleId);

}
