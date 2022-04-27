package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.ShopCartCheckDTO;
import com.fp.mall.product.model.entity.ShopCartItemEntity;
import com.fp.mall.product.model.vo.ShopCartItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCartMapper {

    /**
     * 获取购物车项列表
     * @return 购物车项VO列表
     */
    List<ShopCartItemVO> list();

    /**
     * 根据购物车项id获取购物车项
     * @param cartItemId 购物车项id
     * @return 购物车项VO
     */
    ShopCartItemVO getById(@Param("cartItemId") Long cartItemId);

    /**
     * 根据用户id, 获取用户的购物车信息
     * @param userId 用户id
     * @param expiry 是否已过期
     * @param checked 是否被选中
     * @return 购物车项VO列表
     */
    List<ShopCartItemVO> getShopCartItems(@Param("userId") Long userId, @Param("Expiry") Boolean expiry, @Param("Checked") Boolean checked);

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
     * 勾选购物车项
     * @param userId 用户id
     * @param shopCartCheckDTOList 勾选参数列表
     */
    void checkShopCartItems(@Param("userId") Long userId, @Param("shopCartCheckDTOList") List<ShopCartCheckDTO> shopCartCheckDTOList);

    /**
     * 根据购物车项id, 删除购物车项
     * @param cartItemId 购物车项id
     */
    void deleteById(@Param("cartItemId") Long cartItemId);

    /**
     * 通过用户id的、购物车项id列表, 删除购物车项
     * @param userId 用户id
     * @param shopCartItemIds 购物车项id列表
     */
    void deleteBatchByUserIdAndShopCartItemIds(@Param("userId") Long userId, @Param("shopCartItemIds") List<Long> shopCartItemIds);

    /**
     * 清空用户购物车
     * @param userId 用户id
     */
    void deleteAllByUserId(@Param("userId") Long userId);

}
