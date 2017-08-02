package com.fitt.gbt.qbank.common.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * <p>@Description: 菜单的实体类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@Data
public class Menu {
	private String id;

	private String accountId;

	private String parentId;

	private String parentName;

	private String name;

	private String type;

	private String key;

	private String url;

	private Integer sort;

	private String createdBy;

	private Timestamp createdTime;
}
