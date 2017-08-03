package com.fitt.gbt.qbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * <p>@Description: 题库习题模型</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-28</p>
 * <p>@version: 1.0</p>
 */
@Data
@Entity(name = "exercise")
public class Exercise extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;
	/**
	 * 所属分类: 0-练习题；1-历年真题；2-同学分享题
	 */
	@Column(name = "category")
	@JsonProperty("category")
	private Integer category;
	/**
	 * 类型: 0-单选题，1-多选题，2-判断改错题，3-简答题，4-案例分析，5-论文
	 */
	@Column(name = "type")
	@JsonProperty("type")
	private Integer type;

	@Column(name = "question")
	@JsonProperty("question")
	private String question;

	@Column(name = "option_a")
	@JsonProperty("option_a")
	private String optionA;

	@Column(name = "option_b")
	@JsonProperty("option_b")
	private String optionB;

	@Column(name = "option_c")
	@JsonProperty("option_c")
	private String optionC;

	@Column(name = "option_d")
	@JsonProperty("option_d")
	private String optionD;

	@Column(name = "option_e")
	@JsonProperty("option_e")
	private String optionE;

	@Column(name = "option_f")
	@JsonProperty("option_f")
	private String optionF;

	@Column(name = "option_g")
	@JsonProperty("option_g")
	private String optionG;

	/**
	 * 选择题答案
	 */
	@Column(name = "answer_single")
	@JsonProperty("answer_single")
	private String answerSingle;

	/**
	 * 简答题答案
	 */
	@Column(name = "answer_short")
	@JsonProperty("answer_short")
	private String answerShort;

	/**
	 * 解析
	 */
	@Column(name = "analysis")
	@JsonProperty("analysis")
	private String analysis;

	/**
	 * 所属课本章节
	 */
	@Column(name = "chapter")
	@JsonProperty("chapter")
	private String chapter;

	/**
	 * 所属证书等级：1-一级, 2-二级， 3-三级
	 */
	@Column(name = "cert_level")
	@JsonProperty("cert_level")
	private Integer certLevel;

	@Column(name = "attr1")
	@JsonProperty("attr1")
	private String attr1;

	@Column(name = "attr2")
	@JsonProperty("attr2")
	private String attr2;

	@Column(name = "attr3")
	@JsonProperty("attr3")
	private String attr3;

	@Column(name = "attr4")
	@JsonProperty("attr4")
	private String attr4;
}
