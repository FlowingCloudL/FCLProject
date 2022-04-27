package com.fp.mall.order.handler;

import com.fp.mall.order.dto.ResponseDTO;
import com.fp.mall.order.exception.OrderException;
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
	public ResponseDTO handlerException(Exception e, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 打印堆栈，以供调试
		System.out.println("【全局异常】");
		e.printStackTrace();

		if (e instanceof OrderException) {
			return ResponseDTO.getError(e.getMessage());
		}
		// 未知异常
		else {
			return ResponseDTO.getError("未知错误，请联系管理员");
		}
	}
	
}
