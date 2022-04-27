package com.fp.mall.order.exception;

public class OrderException extends RuntimeException {

    public OrderException() {
        super("订单错误");
    }
}
