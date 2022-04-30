package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.ShopCartCheckDTO;
import com.fp.mall.product.model.entity.ShopCartItemEntity;
import com.fp.mall.product.model.vo.ShopCartItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCartMapper {

    /**
     * 根据用户id, 获取用户的购物车信息
     * @param userId 用户id
     * @param onlyChecked 是否只显示被选中的
     * @return 购物车项VO列表
     */
    List<ShopCartItemVO> getShopCartItems(@Param("userId") Long userId, @Param("onlyChecked") Boolean onlyChecked);

    /**
     * 保存购物车项
     * @param shopCartItem 购物车项
     */
    void save(@Param("shopCartItem") ShopCartItemEntity shopCartItem);

    /**
     * 更新购物车
     * @param shopCartItem 购物车项
     */
    void update(@Param("shopCartItem") ShopCartItemEntity shopCartItem);

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
