package com.fp.common.core.exception;

public class MethodArgumentIsNullException extends RuntimeException{

    public MethodArgumentIsNullException() {
        super("参数不能为空");
    }
}
