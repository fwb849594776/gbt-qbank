package com.fitt.gbt.qbank.message.response;

import lombok.Data;

/**
 * <p>@Description: 文本消息</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@Data
public class TextMessage extends BaseMessage {
	// 回复的消息内容
	private String Content;
}
