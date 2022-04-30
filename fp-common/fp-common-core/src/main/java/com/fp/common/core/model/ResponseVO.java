package com.fp.common.core.model;

public class ResponseVO<T> {

    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public ResponseVO<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseVO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseVO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseVO<T> success() {
        return new ResponseVO<T>()
                .setCode(ResponseEnum.OK.code())
                .setMsg(ResponseEnum.OK.msg());
    }

    public static <T> ResponseVO<T> success(T data) {
        return new ResponseVO<T>()
                .setCode(ResponseEnum.OK.code())
                .setMsg(ResponseEnum.OK.msg())
                .setData(data);
    }

    public static <T> ResponseVO<T> failForShow(String msg) {
        return new ResponseVO<T>()
                .setCode(ResponseEnum.SHOW_FAIL.code())
                .setMsg(msg);
    }

    public static <T> ResponseVO<T> fail(ResponseEnum responseEnum) {
        return new ResponseVO<T>()
                .setCode(responseEnum.code())
                .setMsg(responseEnum.msg());
    }

    public static <T> ResponseVO<T> fail(ResponseEnum responseEnum, T data) {
        return new ResponseVO<T>()
                .setCode(responseEnum.code())
                .setMsg(responseEnum.msg())
                .setData(data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
