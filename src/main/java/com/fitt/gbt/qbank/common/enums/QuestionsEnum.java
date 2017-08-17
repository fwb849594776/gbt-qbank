package com.fitt.gbt.qbank.common.enums;

/**
 * <p>@Description: 题型枚举类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-19</p>
 * <p>@version: 1.0</p>
 */
public enum QuestionsEnum {
	TYPE_RADIO(0, "单选题"),
	TYPE_MULTI(1, "多选题"),
	TYPE_JUDGE(2, "判断改错题"),
	TYPE_SHORT(3, "简述题"),
	TYPE_CASE(4, "案例分析"),
	TYPE_PAPER(5, "论文实操"),
	;


	private int type;
	private String desc;

	QuestionsEnum(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public int type() {
		return this.type;
	}

	public String message() {
		return this.desc;
	}

	public static QuestionsEnum type(int type) {
		for (QuestionsEnum questions : QuestionsEnum.values()) {
			if (type == questions.type()) {
				return questions;
			}
		}
		return null;
	}
}
