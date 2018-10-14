package com.fitt.gbt.qbank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fitt.gbt.qbank.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * <p> 订单表 Mapper 接口 </p>
 *
 * @author SixAwn
 * @since 2018-04-27
 */
public interface OrderMapper extends BaseMapper<Order> {
}