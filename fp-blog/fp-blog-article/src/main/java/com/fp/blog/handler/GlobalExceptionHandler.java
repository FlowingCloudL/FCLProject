package com.fp.blog.handler;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.fp.blog.dto.ResponseDTO;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
		System.out.println("全局异常---------------");
		e.printStackTrace(); 

		// 不同异常返回不同状态码 
		ResponseDTO dto = null;

		if (e instanceof MethodArgumentTypeMismatchException) {
			MethodArgumentTypeMismatchException ee = (MethodArgumentTypeMismatchException) e;
			dto = ResponseDTO.get(ResponseDTO.CODE_INVALID_REQUEST, ee.getMessage());
		}
		// 请求不支持异常
		else if (e instanceof HttpRequestMethodNotSupportedException) {
			HttpRequestMethodNotSupportedException ee = (HttpRequestMethodNotSupportedException) e;
			dto = ResponseDTO.get(ResponseDTO.CODE_INVALID_REQUEST, ee.getMessage());
		}
		// 未登录异常
		else if (e instanceof NotLoginException) {
			NotLoginException ee = (NotLoginException) e;
			dto = ResponseDTO.getNotLogin().setMsg(ee.getMessage());
		}
		// 角色异常
		else if(e instanceof NotRoleException) {
			NotRoleException ee = (NotRoleException) e;
			dto = ResponseDTO.getNotJur("无此角色：" + ee.getRole());
		}
		// 权限异常
		else if(e instanceof NotPermissionException) {
			NotPermissionException ee = (NotPermissionException) e;
			dto = ResponseDTO.getNotJur("无此权限：" + ee.getCode());
		}
		// 被封禁异常
		else if(e instanceof DisableLoginException) {
			DisableLoginException ee = (DisableLoginException) e;
			dto = ResponseDTO.getNotJur("账号被封禁：" + ee.getDisableTime() + "秒后解封");
		}
		// 普通异常, 输出：500 + 异常信息
		else {
			dto = ResponseDTO.getError("未知错误，请联系管理员");
		}
		
		// 返回给前端
		return dto;
	}
	
}
