package com.fitt.gbt.qbank.message.response;

import lombok.Data;

/**
 * <p>@Description: 消息基类（普通用户 -> 公众帐号）</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@Data
public class BaseMessage {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
	// 位0x0001被标志时，星标刚收到的消息
	private int FuncFlag;
}
