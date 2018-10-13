package com.fitt.gbt.qbank.common.model;

import com.fitt.gbt.qbank.common.enums.StatusCodeEnum;
import lombok.Data;

/**
 * <p>@Description: </p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-07-19</p>
 * <p>@version: 1.0</p>
 */
@Data
public class Result {
	private Integer code;

	private String message;

	private Object data;

	public Result() {
	}

	public Result(StatusCodeEnum statusCode) {
		this.code = statusCode.code();
		this.message = statusCode.message();
		this.data = null;
	}

	public Result(StatusCodeEnum statusCode, Object data) {
		this.code = statusCode.code();
		this.message = statusCode.message();
		this.data = data;
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
		this.data = null;
	}

	public Result(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
