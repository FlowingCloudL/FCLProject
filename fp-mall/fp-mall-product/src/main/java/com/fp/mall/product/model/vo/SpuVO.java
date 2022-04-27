package com.fp.mall.product.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SpuVO extends BaseVO {

    @ApiModelProperty("SPU id")
    private Long id;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("SPU名称")
    private String name;

    @ApiModelProperty("商品展示图url, 多个图片逗号分隔")
    private String productPics;

    @ApiModelProperty("商品详情")
    private String desc;

    @ApiModelProperty("商品详情主图url")
    private String descPic;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("状态 | 1:enable, 0:disable, -1:deleted")
    private Integer status;

    //=================================== 额外需求 ===================================

    @ApiModelProperty("分类信息")
    private CategoryVO category;

    @ApiModelProperty("SPU基本属性列表")
    private List<SpuBasicAttrVO> spuAttrValues;

    @ApiModelProperty("sku列表")
    private List<SkuVO> skus;

    @ApiModelProperty("总库存")
    private Integer totalStock;

    @ApiModelProperty("商品销量")
    private Integer saleNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescPic() {
        return descPic;
    }

    public void setDescPic(String descPic) {
        this.descPic = descPic;
    }

    public String getProductPics() {
        return productPics;
    }

    public void setProductPics(String productPics) {
        this.productPics = productPics;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
        this.category = category;
    }

    public List<SpuBasicAttrVO> getSpuAttrValues() {
        return spuAttrValues;
    }

    public void setSpuAttrValues(List<SpuBasicAttrVO> spuAttrValues) {
        this.spuAttrValues = spuAttrValues;
    }

    public List<SkuVO> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuVO> skus) {
        this.skus = skus;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    @Override
    public String toString() {
        return "SpuVO{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", descPic='" + descPic + '\'' +
                ", productPics='" + productPics + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", category=" + category +
                ", spuAttrValues=" + spuAttrValues +
                ", skus=" + skus +
                ", totalStock=" + totalStock +
                ", saleNum=" + saleNum +
                '}';
    }
}
