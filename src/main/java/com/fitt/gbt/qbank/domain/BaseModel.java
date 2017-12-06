package com.fitt.gbt.qbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>@Description: 基础模型对象</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Data
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 2390983430457304660L;
//	@Column(name = "create_time")
//	@Field("create_time")
	@JsonProperty("create_time")
	private Date createTime;

//	@Column(name = "update_time")
//	@Field("update_time")
	@JsonProperty("update_time")
	private Date updateTime;

	@JsonProperty("page_no")
	private int pageNo;

	@JsonProperty("page_size")
	private int pageSize;
}
