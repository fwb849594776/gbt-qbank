package com.fitt.gbt.qbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>@description: 劳协资料库前端控制器</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-12-07</p>
 * <p>@version: 1.0</p>
 */
@Controller
@RequestMapping(value = "/laborcoor/")
public class LaborcoorController {
	/**
	 * 进入历年真题库
	 * @return
	 */
	@RequestMapping("oldpaper")
	public String toOldPaper() {
		return "laborcoor/oldpaper";
	}

	/**
	 * 进入劳协题库
	 * @return
	 */
	@RequestMapping("laborbank")
	public String toLaborBank() {
		return "laborcoor/laborbank";
	}
}
