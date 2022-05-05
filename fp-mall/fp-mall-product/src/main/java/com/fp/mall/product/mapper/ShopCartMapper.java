package com.fp.mall.product.mapper;

import com.fp.mall.product.model.entity.ShopCartItemEntity;
import com.fp.mall.product.model.vo.ShopCartItemVO;
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
    List<ShopCartItemVO> listByUid(@Param("userId") Long userId);

    /**
     * 保存购物车项
     * @param item 购物车项
     */
    void save(@Param("item") ShopCartItemEntity item);

    /**
     * 更新购物车
     * @param item 购物车项
     */
    void update(@Param("item") ShopCartItemEntity item);

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
