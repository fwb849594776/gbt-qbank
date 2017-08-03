package com.fitt.gbt.qbank.service.impl;

import com.fitt.gbt.qbank.common.enums.StatusCodeEnum;
import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.common.utils.BeanUtil;
import com.fitt.gbt.qbank.common.utils.ResultUtil;
import com.fitt.gbt.qbank.domain.User;
import com.fitt.gbt.qbank.repository.UserRepository;
import com.fitt.gbt.qbank.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>@Description: 用户服务实现类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public Result add(User user) {
		Result result = ResultUtil.success();
		try {
			if (null == user) {
				return ResultUtil.error(StatusCodeEnum.ERROR_PARAM_MISSED, "参数为空");
			}
			User db = userRepository.findByUserNameAndUserType(user.getUserName(), user.getUserType());
			if (null != db && !StringUtils.isEmpty(db.getId())) {
				return ResultUtil.error(StatusCodeEnum.ERROR_DATA_EXISTED);
			}

			user.setCreateTime(new Date());
			User insert = userRepository.insert(user);
			result.setData(insert);
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......add() user=[{}] occurred error!", user, e);
		}
		return result;
	}

	@Override
	public Result delete(List<String> ids) {
		Result result = ResultUtil.success();
		try {
			if (null == ids || ids.isEmpty()) {
				return ResultUtil.error(StatusCodeEnum.ERROR_PARAM_MISSED, "id");
			}

			for (String id : ids) {
				userRepository.delete(id);
			}
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......delete() ids=[{}] occurred error!", ids, e);
		}
		return result;
	}

	@Override
	public Result update(User user) {
		Result result = ResultUtil.success();
		try {
			if (null == user || StringUtils.isEmpty(user.getId())) {
				return ResultUtil.error(StatusCodeEnum.ERROR_PARAM_MISSED, "id");
			}
			User db = userRepository.findOne(user.getId());
			BeanUtil.copyProperties(user, db);

			result.setData(userRepository.save(db));
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......update() user=[{}] occurred error!", user, e);
		}
		return result;
	}

	@Override
	public Result findByParameter(String username, Integer userType, Integer userLevel, Integer status, int pageNo, int pageSize) {
		Result result = ResultUtil.success();
		try {
			List<User> users = userRepository.findByParameter(username, userType, userLevel, status, pageNo, pageSize);
			result.setData(users);
		} catch (Exception e) {
			result = ResultUtil.error();
		}
		return result;
	}
}
