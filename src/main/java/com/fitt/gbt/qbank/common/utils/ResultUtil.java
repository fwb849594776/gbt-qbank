package com.fitt.gbt.qbank.common.utils;

import com.fitt.gbt.qbank.common.enums.StatusCodeEnum;
import com.fitt.gbt.qbank.common.model.Result;

/**
 * <p>@Description: 相应结果帮助类</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-07-20</p>
 * <p>@version: 1.0</p>
 */
public class ResultUtil {
	public static Result success() {
		return new Result(StatusCodeEnum.SUCCESS);
	}

	public static Result success(Object data) {
		return new Result(StatusCodeEnum.SUCCESS, data);
	}

	public static Result success(StatusCodeEnum statusCode) {
		return new Result(statusCode);
	}

	public static Result success(StatusCodeEnum statusCode, Object data) {
		return new Result(statusCode, data);
	}

	public static Result error() {
		return new Result(StatusCodeEnum.ERROR);
	}

	public static Result error(Object data) {
		return new Result(StatusCodeEnum.ERROR, data);
	}

	public static Result error(StatusCodeEnum statusCode) {
		return new Result(statusCode);
	}

	public static Result error(StatusCodeEnum statusCode, Object data) {
		return new Result(statusCode, data);
	}

	public static Result parameterMissing(String param) {
		Result result = new Result(StatusCodeEnum.ERROR_PARAM_MISSED);
		result.setMessage(StatusCodeEnum.ERROR_PARAM_MISSED.message().replace("#", param));
		return result;
	}
}
