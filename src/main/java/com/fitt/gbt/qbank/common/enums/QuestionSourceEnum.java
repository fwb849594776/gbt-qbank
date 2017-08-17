package com.fitt.gbt.qbank.common.enums;

/**
 * <p>@Description: 题目来源枚举类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-19</p>
 * <p>@version: 1.0</p>
 */
public enum QuestionSourceEnum {
	SOURCE_EXERCISE(0, "练习题库"),
	SOURCE_OLD_EXAM(1, "历年真题库"),
	SOURCE_NETWORK_COLLECT(2, "网络收集题库"),
	;


	private int source;
	private String desc;

	QuestionSourceEnum(int source, String desc) {
		this.source = source;
		this.desc = desc;
	}

	public int source() {
		return this.source;
	}

	public String message() {
		return this.desc;
	}

	public static QuestionSourceEnum source(int source) {
		for (QuestionSourceEnum statusCode : QuestionSourceEnum.values()) {
			if (source == statusCode.source()) {
				return statusCode;
			}
		}
		return null;
	}
}
