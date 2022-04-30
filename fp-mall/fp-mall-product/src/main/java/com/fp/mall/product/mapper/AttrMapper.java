package com.fp.mall.product.mapper;

import com.fp.mall.product.model.dto.AttrDTO;
import com.fp.mall.product.model.entity.AttrEntity;
import com.fp.mall.product.model.vo.AttrVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttrMapper {

    /**
     * 获取属性VO列表
     * @param attrDTO 属性参数
     * @return 属性VO列表
     */
    List<AttrVO> list(@Param("attrDTO") AttrDTO attrDTO);

    /**
     * 根据分类id，获取属性VO列表
     * @param categoryId 分类id
     * @return 属性VO列表
     */
    List<AttrVO> listByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 根据属性id, 获取属性信息
     * @param attrId 属性id
     * @return 属性信息
     */
    AttrVO getByAttrId(@Param("attrId") Long attrId);

    /**
     * 获取属性总数
     * @param attrDTO 属性参数
     * @return 属性总数
     */
    Long countByAttrDTO(@Param("attrDTO") AttrDTO attrDTO);

    /**
     * 保存属性信息
     * @param attr 属性信息
     */
    void save(@Param("attr") AttrEntity attr);

    /**
     * 更新属性信息
     * @param attr 属性信息
     */
    void update(@Param("attr") AttrEntity attr);

    /**
     * 根据属性id, 删除属性信息
     * @param attrId 属性id
     */
    void deleteByAttrId(@Param("attrId") Long attrId);

}
