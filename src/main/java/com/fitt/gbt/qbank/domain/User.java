package com.fitt.gbt.qbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;

/**
 * <p>@Description: 系统用户模型</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
@Document(collection = "user")
@Data
public class User extends BaseModel {
	@Id
	@Field("id")
	@JsonProperty("id")
	private String id;

	/**
	 * 用户类型：0-注册用户，1-qq用户，2-微信用户，3-新浪微博，4-facebook
	 */
	@Field("user_type")
	@JsonProperty("user_type")
	private Integer userType;

	@Field("user_name")
	@JsonProperty("user_name")
	private String userName;

	@Field("nick_name")
	@JsonProperty("nick_name")
	private String nickName;

	@Field("email")
	@JsonProperty("email")
	private String email;

	@Field("qq")
	@JsonProperty("qq")
	private String qq;

	@Field("weixin")
	@JsonProperty("weixin")
	private String weixin;

	@Field("telephone")
	@JsonProperty("telephone")
	private String telephone;

	/**
	 * 用户头像
	 */
	@Field("head_picture")
	@JsonProperty("head_picture")
	private String headPicture;

	/**
	 * 用户介绍
	 */
	@Field("user_profile")
	@JsonProperty("user_profile")
	private String userProfile;

	/**
	 * 用户等级：0-普通用户，1-赞赏用户，2-会员用户
	 */
	@Field("user_level")
	@JsonProperty("user_level")
	private Integer userLevel;

	@Field("password")
	@JsonProperty("password")
	private String password;

	/**
	 * 用户状态:0-新注册，1-正常，2-过期，3-冻结，4-禁用
	 */
	@Field("status")
	@JsonProperty("status")
	private Integer status;

	/**
	 * 账户余额：元
	 */
	@Field("balance")
	@JsonProperty("balance")
	private Float balance;

	/**
	 * 赞赏金额: 元
	 */
	@Field("appre_amount")
	@JsonProperty("appre_amount")
	private Float appreAmount;
}
