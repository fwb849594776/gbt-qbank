package com.fitt.gbt.qbank.repository;

import com.fitt.gbt.qbank.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <p>@Description: 用户数据操作接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {
	/**
	 * 根据用户名和用户类型查询用户
	 *
	 * @param username
	 * @param userType
	 * @return
	 */
	User findByUserNameAndUserType(String username, Integer userType);
}
