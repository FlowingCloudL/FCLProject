package com.fp.api.mall.product.service;

import com.fp.api.mall.product.model.StockModifyBO;

import java.util.List;

public interface RemoteStockService {

    void decrStock(List<StockModifyBO> bos);

}
