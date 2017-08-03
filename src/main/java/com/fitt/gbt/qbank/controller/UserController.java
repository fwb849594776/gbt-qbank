package com.fitt.gbt.qbank.controller;

import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.domain.User;
import com.fitt.gbt.qbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>@Description: com.fitt.gbt.qbank.controller</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public Result add(@RequestBody User user) {
		return userService.add(user);
	}

	@DeleteMapping
	public Result delete(@RequestBody List<String> ids) {
		return userService.delete(ids);
	}

	@PutMapping
	public Result update(@RequestBody User user) {
		return userService.add(user);
	}

	@GetMapping
	public Result findByParameter(@RequestParam(name = "username", required = false) String username,
								  @RequestParam(name = "user_type", required = false) Integer userType,
								  @RequestParam(name = "user_level", required = false) Integer userLevel,
								  @RequestParam(name = "status", required = false) Integer status,
								  @RequestParam(name = "page_no", required = false, defaultValue = "0") int pageNo,
								  @RequestParam(name = "page_size", required = false, defaultValue = "10") int pageSize) {
		return userService.findByParameter(username, userType, userLevel, status, pageNo, pageSize);
	}
}
