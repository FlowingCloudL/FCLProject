package com.fp.mall.product.service;

import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.vo.AttrVO;

import java.util.List;

public interface AttrService {

    /**
     * 根据属性id, 获取属性VO
     * @param attrId 属性id
     * @return 属性VO
     */
    AttrVO getAttrByAttrId(Long attrId);

    /**
     * 根据分类id, 获取关联的属性信息列表
     * @param categoryId 分类id
     * @return 属性VO列表
     */
    List<AttrVO> listAttrsByCategoryId(Long categoryId);

    /**
     * 保存属性信息
     * @param attr 属性信息
     */
    void saveAttr(AttrDTO attr);

    /**
     * 更新属性信息
     * @param attr 属性信息
     */
    void updateAttr(AttrDTO attr);

    /**
     * 根据属性id, 删除属性信息
     * @param attrId 属性id
     */
    void deleteAttrByAttrId(Long attrId);

    /**
     * 清除属性关联的分类列表中属性列表的缓存
     * @param categoryIds 属性关联的分类列表
     */
    void removeAttrCacheByCategoryId(List<Long> categoryIds);

}
