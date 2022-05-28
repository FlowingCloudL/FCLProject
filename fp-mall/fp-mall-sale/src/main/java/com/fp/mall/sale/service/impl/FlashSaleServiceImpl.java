package com.fp.mall.sale.service.impl;

import com.fp.mall.sale.consts.FlashSaleRedisConst;
import com.fp.mall.sale.mapper.FlashSaleItemMapper;
import com.fp.mall.sale.mapper.FlashsaleSessionMapper;
import com.fp.mall.sale.model.entity.FlashSaleItemEntity;
import com.fp.mall.sale.model.entity.FlashSaleSessionEntity;
import com.fp.mall.sale.service.FlashSaleService;
import com.fp.mall.sale.util.RedisUtil;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlashSaleServiceImpl implements FlashSaleService {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisScript flashsaleScript;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private FlashsaleSessionMapper flashsaleSessionMapper;

    @Resource
    private FlashSaleItemMapper flashSaleItemMapper;

    @Transactional
    @Override
    public boolean purchase(Long itemId, Long uid) {
        String itemKey = FlashSaleRedisConst.FLASHSALE_ITEM_PREFIX + itemId;
        String userCntKey = FlashSaleRedisConst.FLASHSALE_USER_CNT_PREFIX + uid;
        Long res = (Long) redisTemplate.execute(flashsaleScript, Arrays.asList(itemKey, userCntKey), itemId.toString());
        if (res.equals(FlashSaleRedisConst.FLASHSALE_RES_SUCCESS)){
            System.out.println("【秒杀成功】itemId: " + itemId + "   uid: " + uid);
            return true;
        } else { // 秒杀失败
            System.out.println("【秒杀失败】itemId: " + itemId + "   uid: " + uid);
            return false;
        }
    }

    @Override
    public void importToRedis(Long flashSaleId) {
        // 所有场次信息
        List<FlashSaleSessionEntity> flashSaleSessionEntities = flashsaleSessionMapper.listByFlashsaleId(flashSaleId);
        for (FlashSaleSessionEntity flashSaleSession : flashSaleSessionEntities) {
            // 该场次下所有的秒杀物品信息
            List<FlashSaleItemEntity> entityList = flashSaleItemMapper.listByFlashsaleSessionId(flashSaleSession.getFlashsaleSessionId());
            for (FlashSaleItemEntity entity : entityList) {
                String key = FlashSaleRedisConst.FLASHSALE_ITEM_PREFIX + entity.getFlashsaleItemId();
                redisUtil.hset(key, FlashSaleRedisConst.FLASHSALE_ITEM_STOCK, entity.getStock());
                redisUtil.hset(key, FlashSaleRedisConst.FLASHSALE_ITEM_LIMIT, entity.getLimit());
                redisUtil.hset(key, FlashSaleRedisConst.FLASHSALE_ITEM_STATUS, entity.getStatus());
                redisUtil.hset(key, FlashSaleRedisConst.FLASHSALE_ITEM_START_TIME, flashSaleSession.getStartTime());
                redisUtil.hset(key, FlashSaleRedisConst.FLASHSALE_ITEM_END_TIME, flashSaleSession.getEndTime());
                // 计算并设置过期时间
                long expireTime = Duration.between(LocalTime.now(), flashSaleSession.getEndTime()).toMillis() / 1000; // 单位:秒
                redisUtil.setExpire(key, expireTime);
            }

        }
    }
}
