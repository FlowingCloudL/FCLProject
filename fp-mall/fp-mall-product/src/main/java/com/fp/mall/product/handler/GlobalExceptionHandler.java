package com.fp.mall.product.handler;


import com.fp.common.core.model.ResponseVO;
import com.fp.mall.product.exception.ItemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	// 全局异常拦截（拦截项目中的所有异常）
	@ResponseBody
	@ExceptionHandler
	public ResponseVO handlerException(Exception e, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 打印堆栈，以供调试
		System.out.println("【全局异常】");
		e.printStackTrace();

		if (e instanceof ItemException) {
			return ResponseVO.failForShow(e.getMessage());
		}
		// 未知异常
		else {
			return ResponseVO.failForShow("未知错误，请联系管理员");
		}
	}
	
}
