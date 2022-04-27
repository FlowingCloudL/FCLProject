package com.fp.mall.product.service;

import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.entity.AttrEntity;
import com.fp.mall.product.model.vo.AttrVO;

import java.util.List;

public interface AttrService {

    /**
     * 分页获取属性信息列表
     * @param pageDTO 分页参数
     * @param attrDTO
     * @return 属性VO列表（分页）
     */
    PageVO<AttrVO> listAttrsByPage(AttrDTO attrDTO, PageDTO pageDTO);

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
     * 根据属性id， 获取关联的分类id列表
     * @param attrId 属性id
     * @return 分类id列表
     */
    List<Long> listCategoryIdsByAttrId(Long attrId);

    /**
     * 保存属性信息
     * @param attr 属性信息
     * @param categoryIds 分类id列表
     */
    void save(AttrEntity attr, List<Long> categoryIds);

    /**
     * 更新属性信息
     * @param attr 属性信息
     * @param categoryIds 分类id列表
     */
    void update(AttrEntity attr, List<Long> categoryIds);

    /**
     * 根据属性id, 删除属性信息
     * @param attrId 属性id
     */
    void deleteByAttrId(Long attrId);

    /**
     * 清除属性关联的分类列表中属性列表的缓存
     * @param categoryIds 属性关联的分类列表
     */
    void removeAttrByCategoryId(List<Long> categoryIds);

}
