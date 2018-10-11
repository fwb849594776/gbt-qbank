package com.fitt.gbt.qbank.mapper;

import com.fitt.gbt.qbank.domain.OrderList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p> 订单表 Mapper 接口 </p>
 *
 * @author Chuck[ZhengCongChun]
 * @since 2018-04-27
 */
@Repository
public interface OrderListMapper {
    @Select("select * from order_list where id = #{id}")
    OrderList selectById(Integer id);

    @Insert("insert into order_list(username,) values(#order.username, #order.idCard, #order.email, #order.weixin, #order.telephone, #order.createTime)")
    OrderList insert(@Param("order") OrderList order);
}