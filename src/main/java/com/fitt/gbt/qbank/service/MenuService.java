package com.fitt.gbt.qbank.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * <p>@Description: 微信菜单服务接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
public interface MenuService {
	/**
	 * 获取菜单
	 *
	 * @param accessToken
	 * @return
	 */
	JSONObject getMenu(String accessToken);

	/**
	 * 创建菜单
	 *
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	int createMenu(Map<String, Object> menu, String accessToken);

	/**
	 * 删除菜单
	 *
	 * @param accessToken
	 * @return
	 */
	int deleteMenu(String accessToken);
}
