package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.ShopCartCheckDTO;
import com.fp.mall.product.model.dto.ShopCartModifyDTO;
import com.fp.mall.product.model.entity.ShopCartItemEntity;
import com.fp.mall.product.model.vo.ShopCartItemVO;

import java.util.List;

public interface ShopCartService {

	/**
	 * 获取用户所有未过期的购物项
	 * @return 未过期的购物项
	 */
	List<ShopCartItemVO> listShopCartItems();

	/**
	 * 获取已过期的购物项
	 * @return 已过期的购物项
	 */
	List<ShopCartItemVO> listExpiryShopCartItems();

	/**
	 * 获取被选中的购物车项
	 * @return 被选中的购物车项
	 */
	List<ShopCartItemVO> listCheckedShopCartItems();

	/**
	 * 添加购物车项
     * @param userId 用户id
     * @param shopCartModifyDTO 购物车项DTO
     * @param priceBefore 加入购物车时的价格
     */
	void addShopCartItem(Long userId, ShopCartModifyDTO shopCartModifyDTO, Long priceBefore);

	/**
	 * 更新购物车项
	 * @param userId 用户id
	 * @param shopCartItemEntity 购物车项Entity
	 */
	void updateShopCartItem(Long userId, ShopCartItemEntity shopCartItemEntity);

	/**
	 * 批量勾选购物车项
	 * @param userId 用户id
	 * @param params 参数
	 */
	void checkShopCartItems(Long userId, List<ShopCartCheckDTO> params);

	/**
	 * 批量删除购物车项
	 * @param userId 用户id
	 * @param shopCartItemIds 购物车项id列表
	 */
	void deleteByItemIds(Long userId, List<Long> shopCartItemIds);

	/**
	 * 清空用户购物车
	 * @param userId 用户id
	 */
	void deleteAllByUserId(Long userId);

}