package com.fp.api.mall.product.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockModifyBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long skuId;

    private Integer count;

}
