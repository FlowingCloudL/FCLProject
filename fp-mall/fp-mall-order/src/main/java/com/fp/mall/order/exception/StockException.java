package com.fp.mall.order.exception;

public class StockException extends RuntimeException {

    public StockException() {
        super("库存服务错误");
    }
}
