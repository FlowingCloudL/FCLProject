package com.fp.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.mall.product.model.entity.ShopCartItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopCartMapper {

    /**
     * 根据用户id, 获取用户的购物车信息
     * @param userId 用户id
     * @return 购物车项VO列表
     */
    List<ShopCartItemEntity> listByUid(@Param("userId") Long userId);

    /**
     * 添加购物车项
     * @param item 购物车项
     */
    void addItem(@Param("item") ShopCartItemEntity item);

    /**
     * 更改购物车项数量
     * @param id 购物车项id
     * @param uid 用户id
     * @param count 目标数量
     */
    void changeCount(@Param("id") Long id, @Param("uid") Long uid, @Param("count") Integer count);

    /**
     * 更改购物车项数量
     * @param id 购物车项id
     * @param uid 用户id
     * @param skuId 目标SKU的id
     */
    void changeSku(@Param("id") Long id, @Param("uid") Long uid, @Param("skuId") Long skuId);

    /**
     * 通过用户id的、购物车项id列表, 删除购物车项
     * @param userId 用户id
     * @param shopCartItemIds 购物车项id列表
     */
    void deleteBatch(@Param("uid") Long userId, @Param("shopCartItemIds") List<Long> shopCartItemIds);

    /**
     * 清空用户购物车
     * @param userId 用户id
     */
    void clearUserShopCart(@Param("uid") Long userId);

}
