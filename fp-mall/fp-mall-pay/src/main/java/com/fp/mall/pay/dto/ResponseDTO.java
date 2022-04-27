package com.fp.mall.pay.dto;

import java.io.Serializable;


/**
 * ajax请求返回Json格式数据的封装 
 */
public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;	  // 序列化版本号
	
	public static final int CODE_SUCCESS = 200;			  // 成功状态码
	public static final int CODE_ERROR = 500;			  // 错误状态码
	public static final int CODE_WARNING = 501;			  // 警告状态码
	public static final int CODE_NOT_JUR = 403;		   	  // 无权限状态码
	public static final int CODE_NOT_LOGIN = 401;		  // 未登录状态码
	public static final int CODE_INVALID_REQUEST = 400;	  // 无效请求状态码

	public int code; 	    // 状态码
	public String msg;  	// 描述信息
	public Object data;     // 携带对象
	

	public int getCode() {
		return this.code;
	}
	public String getMsg() {
		return this.msg;
	}
	public Object getData() {
		return this.data;
	}

	/**
	 * 设置code，连缀风格
	 */
	public ResponseDTO setCode(int code) {
		this.code = code;
		return this;
	}

	/**
	 * 设置msg，连缀风格
	 */
	public ResponseDTO setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	/**
	 * 设置data，连缀风格
	 */
	public ResponseDTO setData(Object data) {
		this.data = data;
		return this;
	}

	// ========================================================  构建  ==============================================================

	public ResponseDTO(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	// 返回成功
	public static ResponseDTO getSuccess() {
		return new ResponseDTO(CODE_SUCCESS, "ok", null);
	}
	public static ResponseDTO getSuccess(String msg) {
		return new ResponseDTO(CODE_SUCCESS, msg, null);
	}
	public static ResponseDTO getSuccess(String msg, Object data) {
		return new ResponseDTO(CODE_SUCCESS, msg, data);
	}

	// 返回失败
	public static ResponseDTO getError() {
		return new ResponseDTO(CODE_ERROR, "error", null);
	}
	public static ResponseDTO getError(String msg) {
		return new ResponseDTO(CODE_ERROR, msg, null);
	}

	// 返回警告
	public static ResponseDTO getWarning() {
		return new ResponseDTO(CODE_ERROR, "warning", null);
	}
	public static ResponseDTO getWarning(String msg) {
		return new ResponseDTO(CODE_WARNING, msg, null);
	}

	// 返回未登录
	public static ResponseDTO getNotLogin() {
		return new ResponseDTO(CODE_NOT_LOGIN, "未登录", null);
	}

	// 返回没有权限的
	public static ResponseDTO getNotJur(String msg) {
		return new ResponseDTO(CODE_NOT_JUR, msg, null);
	}

	// 返回一个自定义状态码的
	public static ResponseDTO get(int code, String msg){
		return new ResponseDTO(code, msg, null);
	}

	@Override
	public String toString() {
		return "ResponseDTO{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
