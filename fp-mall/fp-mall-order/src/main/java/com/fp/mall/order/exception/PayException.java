package com.fp.mall.order.exception;

public class PayException extends RuntimeException {

    public PayException() {
        super("余额服务错误");
    }
}
