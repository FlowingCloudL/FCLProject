package com.fp.api.mall.product.service;

import com.fp.api.mall.product.model.OrderSpuBO;

/**
 * SPU远程调用服务接口
 *
 * @author FlowingCloudL
 * @date 2022/5/12 14:15
 */
public interface RemoteSpuService {

    /**
     *
     * @param skuId
     * @return
     */
    OrderSpuBO getSpuBySkuId(Long skuId);

}
