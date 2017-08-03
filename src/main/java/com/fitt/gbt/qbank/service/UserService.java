package com.fitt.gbt.qbank.service;

import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.domain.User;

import java.util.List;

/**
 * <p>@Description: 用户服务接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
public interface UserService {
	/**
	 * 新增
	 *
	 * @param user
	 * @return
	 */
	Result add(User user);

	/**
	 * 删除
	 *
	 * @param ids
	 * @return
	 */
	Result delete(List<String> ids);

	/**
	 * 修改
	 *
	 * @param user
	 * @return
	 */
	Result update(User user);

	/**
	 * 根据参数分页查询
	 *
	 * @param username
	 * @param userType
	 * @param userLevel
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Result findByParameter(String username, Integer userType, Integer userLevel, Integer status, int pageNo, int pageSize);
}
