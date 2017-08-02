package com.fitt.gbt.qbank.common.enums;

/**
 * <p>@Description: 状态码枚举类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-19</p>
 * <p>@version: 1.0</p>
 */
public enum StatusCodeEnum {
	ERROR(-1, "操作失败"),
	SUCCESS(0, "操作成功"),
	UNKNOWN(99999, "未知错误"),
	ERROR_REQUEST_FORMAT(10002, "请求格式错误"),
	ERROR_PARAM_MISSED(10003, "请求参数缺少[#]参数"),
	ERROR_DATA_EXISTED(10004, "数据已存在"),
	ERROR_DATA_NOT_EXISTED(10005, "数据未查询到"),
	ERROR_DATA_NOT_EXISTED1(10006, "数据已存在"),
	ERROR_DATA_NOT_EXISTED2(10007, "数据已存在"),
	ERROR_DATA_NOT_EXISTED3(10008, "数据已存在"),
	ERROR_DATA_NOT_EXISTED4(10009, "数据已存在"),
	ERROR_USER_EXISTED(10010, "用户名已存在"),
	ERROR_USER_NOT_EXISTS(10011, "用户名不存在"),
	ERROR_PASSWORD_INVALID(10012, "密码不正确"),
	ERROR_PHONE_REGISTERED(10013, "手机号已被注册"),
	;
	private int code;
	private String message;

	StatusCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}

	public static StatusCodeEnum code(int code) {
		for (StatusCodeEnum statusCode : StatusCodeEnum.values()) {
			if (code == statusCode.code()) {
				return statusCode;
			}
		}
		return null;
	}
}
