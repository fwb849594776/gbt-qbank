package com.fitt.gbt.qbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>@Description: com.fitt.gbt.qbank.domain</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-04</p>
 * <p>@version: 1.0</p>
 */
@Data
@Document(collection = "message")
public class Message implements Serializable {
	private static final long serialVersionUID = 5031188552556081781L;

	@Id
	@Field("id")
	@JsonProperty("id")
	private String id;

	@Field("text")
	@JsonProperty("text")
	private String text;

	@Field("summary")
	@JsonProperty("summary")
	private String summary;

	@Field("created")
	@JsonProperty("created")
	private Date created = new Date();

}
