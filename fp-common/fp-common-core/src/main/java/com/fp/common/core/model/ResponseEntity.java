package com.fp.common.core.model;

public class ResponseEntity<T> {

    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public ResponseEntity<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseEntity<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseEntity<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<T>()
                .setCode(ResponseEnum.OK.code())
                .setMsg(ResponseEnum.OK.msg());
    }

    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<T>()
                .setCode(ResponseEnum.OK.code())
                .setMsg(ResponseEnum.OK.msg())
                .setData(data);
    }

    public static <T> ResponseEntity<T> failForShow(String msg) {
        return new ResponseEntity<T>()
                .setCode(ResponseEnum.SHOW_FAIL.code())
                .setMsg(msg);
    }

    public static <T> ResponseEntity<T> fail(ResponseEnum responseEnum) {
        return new ResponseEntity<T>()
                .setCode(responseEnum.code())
                .setMsg(responseEnum.msg());
    }

    public static <T> ResponseEntity<T> fail(ResponseEnum responseEnum, T data) {
        return new ResponseEntity<T>()
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
