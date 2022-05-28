package com.fp.mall.sale.service;

/**
 * 秒杀服务 - 接口
 *
 * @author FlowingCloudL
 * @date 2022/5/26 16:22
 */
public interface FlashSaleService {

    /**
     * 秒杀抢购
     * @return 是否成功
     * @param itemId 秒杀物品id
     * @param uid 用户id
     */
    boolean purchase(Long itemId, Long uid);

    /**
     * 将指定秒杀数据导入Redis中
     * @param flashSaleId 秒杀活动id
     */
    void importToRedis(Long flashSaleId);

}
