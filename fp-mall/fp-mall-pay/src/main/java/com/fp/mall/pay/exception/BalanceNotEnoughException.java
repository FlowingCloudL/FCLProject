package com.fp.mall.pay.exception;

public class BalanceNotEnoughException extends RuntimeException {

    public BalanceNotEnoughException() {
        super("余额不足");
    }
}
