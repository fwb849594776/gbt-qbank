package com.fitt.gbt.qbank.repository.impl;

import com.fitt.gbt.qbank.domain.User;
import com.fitt.gbt.qbank.repository.UserRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>@Description: 用户数据操作自定义接口实现类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> findByParameter(String username, Integer userType,
									  Integer userLevel, Integer status,
									  int pageNo, int pageSize) {
		List<User> users = new ArrayList<>();
		try {
			Query query = new Query();
			Criteria criteria = new Criteria();
			if (!StringUtils.isEmpty(username)) {
				criteria.and("username").is(username);
			}
			if (null != userType) {
				criteria.and("userType").is(userType);
			}
			if (null != userLevel) {
				criteria.and("userLevel").is(userLevel);
			}
			if (null != status) {
				criteria.and("status").is(status);
			}
			query.addCriteria(criteria);

			Pageable pageable = new PageRequest(pageNo, pageSize, Sort.Direction.DESC, "createTime");
			query.with(pageable);

			logger.info("......findByParameter() queryString={}", query.toString());

			users = mongoTemplate.find(query.with(pageable), User.class);
		} catch (Exception e) {
			logger.error("......findByParameter() query user by parameter=[username={}, userType={}, userLevel={}, status={}, pageNo={}, pageSize={}] occurred error!",
					username, userType, userLevel, status, pageNo, pageSize, e);
		}
		return users;
	}
}
