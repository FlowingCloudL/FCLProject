package com.fp.mall.product.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpuSearchDTO {

	@ApiModelProperty("spuId")
	private Long spuId;

	@ApiModelProperty("品牌ID")
	private Long brandId;

	@ApiModelProperty("分类ID")
	private Long categoryId;

	@ApiModelProperty("spu名称")
	private String name;

	@ApiModelProperty("商品状态： 0.全部  1.销售中  2.已售罄  3.已下架 ")
	private Integer status;

	@ApiModelProperty("最低价")
	private Long minPrice;

	@ApiModelProperty("最高价")
	private Long maxPrice;

	@ApiModelProperty("最低销量")
	private Long minSaleNum;

	@ApiModelProperty("最高销量")
	private Long maxSaleNum;

	@ApiModelProperty("当前价排序 0：倒序 1：顺序")
	private Integer priceFeeSort;

	@ApiModelProperty("市场价排序 0：倒序 1：顺序")
	private Integer marketPriceFeeSort;

	@ApiModelProperty("销量排序 0：倒序 1：顺序")
	private Integer saleNumSort;

	@ApiModelProperty("库存排序 0：倒序 1：顺序")
	private Integer stockSort;

	@ApiModelProperty("序号排序 0：倒序 1：顺序")
	private Integer seqSort;

	@ApiModelProperty("创建时间排序 0：倒序 1：顺序")
	private Integer createTimeSort;

}