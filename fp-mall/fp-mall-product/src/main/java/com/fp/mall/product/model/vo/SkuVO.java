package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SkuVO extends BaseVO {

    @ApiModelProperty("SKU id")
    private Long id;

    @ApiModelProperty("SPU id")
    private Long spuId;

    @ApiModelProperty("SKU名称")
    private String name;

    @ApiModelProperty("多个销售属性值id逗号分隔")
    private String attrs;

    @ApiModelProperty("图片url")
    private String imgUrl;

    @ApiModelProperty("售价，整数方式保存")
    private Long price;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Integer status;

    //=================================== 额外需求 ===================================

    @ApiModelProperty("SKU销售属性列表")
    private List<SkuSaleAttrVO> spuSkuAttrValues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SkuSaleAttrVO> getSpuSkuAttrValues() {
        return spuSkuAttrValues;
    }

    public void setSpuSkuAttrValues(List<SkuSaleAttrVO> spuSkuAttrValues) {
        this.spuSkuAttrValues = spuSkuAttrValues;
    }

    @Override
    public String toString() {
        return "SkuVO{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", spuId=" + spuId +
                ", name='" + name + '\'' +
                ", attrs='" + attrs + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status=" + status +
                ", spuSkuAttrValues=" + spuSkuAttrValues +
                '}';
    }
}
