package com.fitt.gbt.qbank.message.request;

import lombok.Data;

/**
 * <p>@Description: 音频消息</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@Data
public class VoiceMessage extends BaseMessage {
	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;
}
