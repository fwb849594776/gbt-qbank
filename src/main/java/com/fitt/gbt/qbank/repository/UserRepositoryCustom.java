package com.fitt.gbt.qbank.repository;

import com.fitt.gbt.qbank.domain.User;

import java.util.List;

/**
 * <p>@Description: 用户数据操作自定义接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
public interface UserRepositoryCustom {
	/**
	 * 根据参数分页查询用户列表
	 *
	 * @param username
	 * @param userType
	 * @param userLevel
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<User> findByParameter(String username, Integer userType, Integer userLevel, Integer status, int pageNo, int pageSize);
}
