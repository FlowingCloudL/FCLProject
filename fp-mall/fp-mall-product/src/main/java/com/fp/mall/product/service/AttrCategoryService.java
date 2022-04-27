package com.fp.mall.product.service;

import com.fp.mall.product.model.vo.CategoryVO;

import java.util.List;

public interface AttrCategoryService {

	/**
	 * 根据属性Id，获取关联的分类VO列表
	 * @param attrId 属性id
	 * @return
	 */
	List<CategoryVO> listByAttrId(Long attrId);

	/**
	 * 保存属性与分类的关联信息
	 * @param attrId 属性id
	 * @param categoryIds 分类id列表
	 */
	void save(Long attrId, List<Long> categoryIds);

	/**
	 * 更新属性与分类的关联信息
	 * @param attrId 属性id
	 * @param categoryIds 分类id列表
	 * @return
	 */
	List<Long> update(Long attrId, List<Long> categoryIds);


}