package com.fp.mall.product.remote;

import com.fp.api.mall.product.model.StockModifyBO;
import com.fp.api.mall.product.service.RemoteStockService;
import com.fp.mall.product.service.StockService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DubboService
public class RemoteStockServiceImpl implements RemoteStockService {

    @Resource
    private StockService stockService;

    @Transactional
    @Override
    public void decrStock(List<StockModifyBO> bos) {
        for (StockModifyBO bo : bos) {
            int row = stockService.reduceDirectly(bo.getSkuId(), bo.getCount());
            if (row <= 0) { // 扣减库存失败
                throw new RuntimeException("库存不足");
            }
        }
    }
}
