package com.fp.common.core.model;

public enum ResponseEnum {

	/**
	 * ok
	 */
	OK(0, "ok"),

	/**
	 * 用于直接显示提示用户的错误，内容由输入内容决定
	 */
	SHOW_FAIL(1, ""),

	/**
	 * 参数校验不通过，内容由输入内容决定
	 */
	ARGUMENT_NOT_VALID(2, ""),

	/**
	 * 无法读取获取请求参数
	 */
	HTTP_MESSAGE_NOT_READABLE(3, "请求参数格式有误"),

	/**
	 * 未授权
	 */
	UNAUTHORIZED(4, "Unauthorized"),

	/**
	 * 服务器出了点小差
	 */
	EXCEPTION(5, "服务器出了点小差"),

	/**
	 * 数据异常
	 */
	DATA_ERROR(7, "数据异常，请刷新后重新操作"),

	/**
	 * 一些需要登录的接口，而实际上因为前端无法知道token是否已过期，导致token已失效时，
	 * 应该返回一个状态码，告诉前端token已经失效了，及时清理
	 */
	CLEAN_TOKEN(8, "clean token"),

	/**
	 * 刷新token已过期
	 */
	REFRESH_TOKEN_EXIST(9, "refresh token exist"),

	/**
	 * 数据不完整
	 */
	DATA_INCOMPLETE(10, "数据不完整"),

	/**
	 * 01开头代表商品
	 */
	SPU_NOT_EXIST(1000, "spu not exist"),

	/**
	 * 02开头代表购物车
	 */
	SHOP_CART_NOT_EXIST(2000, "shop cart not exist"),

	/**
	 * 03开头代表订单
	 */
	ORDER_NOT_EXIST(3000, "order not exist"),

	/**
	 * 请勿重复提交订单，
	 * 1.当前端遇到该异常时，说明前端防多次点击没做好
	 * 2.提示用户 订单已发生改变，请勿重复下单
	 */
	REPEAT_ORDER(3002, "please don't repeat order"),

	/**
	 * 订单已过期，当前端看到该状态码的时候，提示订单信息已过期，请重新确认后提交，此时用户点击确定，前端刷新页面。
	 */
	ORDER_EXPIRED(3003, "order expired"),

	/**
	 * 订单已支付，无法取消订单
	 */
	ORDER_PAYED(3007, "order payed"),

	/**
	 * 订单未发货，无法确认收货
	 */
	ORDER_NO_DELIVERY(3008, "order no delivery"),

	/**
	 * 库存不足，body会具体返回那个skuid的库存不足
	 */
	NOT_STOCK(3010, "not stock"),

	/**
	 * 订单未完成或未关闭，无法删除订单
	 */
	ORDER_NOT_FINISH_OR_CLOSE(3011, "order not finish or close"),

	/**
	 * 订单未支付
	 */
	ORDER_NOT_PAYED(3012, "order not payed"),

	/**
	 * 订单已失败
	 */
	ORDER_HAS_FAILED(3013, "order has failed"),

	/**
	 * 没有查询权限
	 */
	REFUND_NOT_PERMISSION(3024, "refund not permission"),

	/**
	 * 撤销失败 当前状态不允许此操作
	 */
	REFUND_STATUS_CHECK(3034, "refund status check"),

	/**
	 * 04 开头代表注册登录之类的异常状态
	 * 社交账号未绑定，当前端看到该异常时，应该在合适的时间（比如在购买的时候跳）根据社交账号的类型，跳转到绑定系统账号的页面
	 */
	SOCIAL_ACCOUNT_NOT_BIND(4001, "social account not bind"),

	/**
	 * 有些时候第三方系统授权之后，会有个临时的key，比如小程序的session_key
	 * 这个异常代表session_key过期，前端遇到这个问题的时候，应该再次调用社交登录的接口，刷新session_key
	 */
	BIZ_TEMP_SESSION_KEY_EXPIRE(4002, "biz temp session key expire"),

	/**
	 * 账号未注册，前端看到这个状态码，弹出选择框，提示用户账号未注册，是否进入注册页面，用户选择是，进入注册页面
	 */
	ACCOUNT_NOT_REGISTER(4003, "account not register");


    private final Integer code;

	private final String msg;

	public Integer code() {
		return code;
	}

	public String msg() {
		return msg;
	}

	ResponseEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResponseEnum{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + "} " + super.toString();
	}

}
