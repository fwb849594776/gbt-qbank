/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.service;

import com.fitt.gbt.qbank.common.enums.StatusCodeEnum;
import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.common.utils.ApplicationContextUtil;
import com.fitt.gbt.qbank.common.utils.ResultUtil;
import com.fitt.gbt.qbank.domain.OrderList;
import com.fitt.gbt.qbank.mapper.OrderListMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Service("orderListService")
public class OrderListService {
    private static final Logger logger = LoggerFactory.getLogger(OrderListService.class);

    //@Autowired
    private OrderListMapper orderListMapper = (OrderListMapper)ApplicationContextUtil.getBean("orderListMapper");

    public Result add(OrderList order) {
        Result<OrderList> result = ResultUtil.success();

        try {
            // 校验参数
            if (null == order || StringUtils.isEmpty(order.getIdCard())) {
                return ResultUtil.parameterMissing("idCard");
            }
            if (null == order || StringUtils.isEmpty(order.getTelephone())) {
                return ResultUtil.parameterMissing("telephone");
            }
            // 查询是否已经存在
            List<OrderList> orders = null;
            if (null != orders && !orders.isEmpty()) {
                return ResultUtil.error(StatusCodeEnum.ERROR_DATA_EXISTED);
            }
            order.setCreateTime(new Date());
            int ret = orderListMapper.insert(order);
            result.setData(order);
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
            //List<OrderList> orders = orderListRepository.findAll(ids);
            //if (null == orders || orders.isEmpty()) {
            //    return ResultUtil.error(StatusCodeEnum.ERROR_DATA_NOT_EXISTED);
            //}
            //orderListRepository.delete(orders);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public Result<OrderList> update(OrderList exercise) {
        Result<OrderList> result = ResultUtil.success();

        try {
            if (null == exercise || StringUtils.isEmpty(exercise.getId())) {
                return ResultUtil.error(StatusCodeEnum.ERROR_REQUEST_FORMAT);
            }

            //OrderList data = orderListRepository.findOne(exercise.getId());
            //if (null == data) {
            //    return ResultUtil.error(StatusCodeEnum.ERROR_DATA_NOT_EXISTED);
            //}
            //
            //BeanUtil.copyProperties(exercise, data);
            //
            //orderListRepository.saveAndFlush(data);
            //
            //result.setData(data);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public Result findAll(final String idCard, final String telephone, final int pageNo, final int pageSize) {
        Result result = ResultUtil.success();

        try {
            //Pageable pageable = new PageRequest(pageNo, pageSize, Sort.Direction.ASC, "id");

            //Page<OrderList> pages = orderListRepository.findAll(new Specification<OrderList>() {
            //    @Override
            //    public Predicate toPredicate(Root<OrderList> root, CriteriaQuery<?> query,
            //                                 CriteriaBuilder criteriaBuilder) {
            //        List<Predicate> list = new ArrayList<Predicate>();
            //        if (!StringUtils.isEmpty(idCard)) {
            //            list.add(
            //                criteriaBuilder.equal(root.get("idCard").as(String.class), idCard));
            //        }
            //        if (!StringUtils.isEmpty(telephone)) {
            //            list.add(criteriaBuilder.equal(root.get("telephone").as(String.class), telephone));
            //        }
            //        Predicate[] predicates = new Predicate[list.size()];
            //        return criteriaBuilder.and(list.toArray(predicates));
            //    }
            //}, pageable);

            //result.setData(pages);
        } catch (Exception e) {
            result = ResultUtil.error();
            logger.error("......findAll() occurred error!", e);
        }
        return result;
    }

    public List<OrderList> list(String idCard, String telephone, int pageNo, int pageSize) {
        List<OrderList> dataList = new ArrayList<>();
        try {
            Result result = findAll(idCard, telephone, pageNo, pageSize);
            if (StatusCodeEnum.SUCCESS.code() == result.getCode() && null != result.getData()) {
                //Page<OrderList> page = (Page<OrderList>)result.getData();
                //if (null != page && null != page.getContent()) { dataList = page.getContent(); }
            }
        } catch (Exception e) {
            logger.error("......findAll() occurred error!", e);
        }
        return dataList;
    }

    public OrderList findById(Integer id) {
        return orderListMapper.selectById(id);
    }

    public List<OrderList> findAppointmentOrderList() {
        return null;
    }
}
