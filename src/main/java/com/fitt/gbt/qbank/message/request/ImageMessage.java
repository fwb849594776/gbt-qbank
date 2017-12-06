package com.fitt.gbt.qbank.message.request;

import lombok.Data;

/**
 * <p>@Description: 图片消息</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@Data
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;
}