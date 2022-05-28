package com.fp.mall.sale.consts;

public class FlashSaleRedisConst {

    public static String FLASHSALE_ITEM_PREFIX = "fp_mall_sale:flashsale:item:";
    public static String FLASHSALE_USER_CNT_PREFIX = "fp_mall_sale:flashsale:user_cnt:";
    public static String FLASHSALE_ITEM_STOCK = "stock";
    public static String FLASHSALE_ITEM_LIMIT = "limit";
    public static String FLASHSALE_ITEM_STATUS = "status";
    public static String FLASHSALE_ITEM_START_TIME = "start_time";
    public static String FLASHSALE_ITEM_END_TIME = "end_time";

    public static Long FLASHSALE_RES_FAIL_END = 0L;
    public static Long FLASHSALE_RES_FAIL_LIMIT = 1L;
    public static Long FLASHSALE_RES_FAIL_STOCK = 2L;
    public static Long FLASHSALE_RES_SUCCESS = 3L;

}
