package com.fp.mall.product.service;

import com.fp.mall.product.model.entity.AttrEntity;
import com.fp.mall.product.model.entity.AttrValueEntity;
import com.fp.mall.product.model.vo.AttrVO;

import java.util.List;

public interface AttrValueService {

	/**
	 * 根据属性id，保存与之关联的属性值列表
	 * @param attrId 属性id
	 * @param attrValues 属性值列表
	 */
	void save(Long attrId, List<AttrValueEntity> attrValues);

	/**
	 * 根据属性值信息和属性id，更新属性值信息
	 * @param attrVO
	 * @param dbAttr
	 */
//	void update(AttrEntity attrVO, AttrVO dbAttr);

}