package com.fp.mall.product.model.dto;

import com.fp.common.core.model.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SpuSearchDTO {

	@ApiModelProperty("分页参数")
	private PageDTO pageDTO;

	@ApiModelProperty("品牌ID")
	private Long brandId;

	@ApiModelProperty("分类ID")
	private Long categoryId;

	@ApiModelProperty("spu关键词")
	private String spuKeyword;

	@ApiModelProperty("商品状态 [0.全部  1.销售中  2.已售罄  3.已下架]")
	private Byte status;

	@ApiModelProperty("最低价")
	private Long minPrice;

	@ApiModelProperty("最高价")
	private Long maxPrice;

	@ApiModelProperty("最低销量")
	private Long minSales;

	@ApiModelProperty("最高销量")
	private Long maxSales;

	@ApiModelProperty("排序规则 [0:销量, 1:价格]")
	private Byte sortRule;

	@ApiModelProperty("排序方式 [0:升序, 1:降序]")
	private Byte sortType;

}