/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fitt.gbt.qbank.common.enums.StatusCodeEnum;
import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.common.utils.ResultUtil;
import com.fitt.gbt.qbank.domain.Order;
import com.fitt.gbt.qbank.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单服务接口类
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;

    public Result add(Order order) {
        Result result = ResultUtil.success();

        try {
            // 校验参数
            if (null == order || StringUtils.isEmpty(order.getIdCard())) {
                return ResultUtil.parameterMissing("idCard");
            }
            if (StringUtils.isEmpty(order.getTelephone())) {
                return ResultUtil.parameterMissing("telephone");
            }
            // 查询是否已经存在
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id_card", order.getIdCard());
            List<Order> orders = orderMapper.selectList(queryWrapper);
            if (!orders.isEmpty()) {
                return ResultUtil.error(StatusCodeEnum.ERROR_DATA_EXISTED);
            }
            order.setCreateTime(new Date());
            int ret = orderMapper.insert(order);
            result.setData(ret);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public Result delete(List<Integer> ids) {
        Result result = ResultUtil.success();
        try {
            if (null == ids || ids.isEmpty()) {
                return ResultUtil.parameterMissing("id");
            }
            orderMapper.deleteBatchIds(ids);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public Result update(Order condition) {
        Result result = ResultUtil.success();

        try {
            if (null == condition || StringUtils.isEmpty(condition.getId())) {
                return ResultUtil.error(StatusCodeEnum.ERROR_REQUEST_FORMAT);
            }

            Order order = orderMapper.selectById(condition.getId());
            if (null == order) {
                return ResultUtil.error(StatusCodeEnum.ERROR_DATA_NOT_EXISTED);
            }

            orderMapper.updateById(order);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public Result findAll(final String idCard, final String telephone, final int pageNo, final int pageSize) {
        Result result = ResultUtil.success();

        try {
            IPage<Order> page = new Page<>();
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            IPage<Order> orderIPage = orderMapper.selectPage(page, queryWrapper);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public List<Order> list(String idCard, String telephone, int pageNo, int pageSize) {
        List<Order> dataList = new ArrayList<>();
        try {
            Result result = findAll(idCard, telephone, pageNo, pageSize);
            if (StatusCodeEnum.SUCCESS.code() == result.getCode() && null != result.getData()) {
               dataList = (List<Order>)result.getData();
            }
        } catch (Exception e) {
            logger.error("......findAll() occurred error!", e);
        }
        return dataList;
    }

    public Order findById(Integer id) {
        return orderMapper.selectById(id);
    }

    public List<Order> findAppointmentOrderList() {
        return null;
    }
}
