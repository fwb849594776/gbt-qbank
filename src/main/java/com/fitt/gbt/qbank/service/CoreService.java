package com.fitt.gbt.qbank.service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> Description	: 核心服务接口 </p>
 * <p> Copyright	: Copyright (c) 2017 by FITT</p>
 * <p> Author 		: Miles[ZhengCongChun] </p>
 * <p> Create		: 2017-12-05 23:34 </p>
 * <p> version 		: 1.0 </p>
 */
public interface CoreService {
    String processRequest(HttpServletRequest request);
}
