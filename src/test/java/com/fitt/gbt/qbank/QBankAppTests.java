package com.fitt.gbt.qbank;

import com.alibaba.fastjson.JSON;
import com.fitt.gbt.qbank.domain.OrderList;
import com.fitt.gbt.qbank.mapper.OrderListMapper;
import com.fitt.gbt.qbank.service.OrderListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QBankAppTests {

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private OrderListMapper orderListMapper;

    @Test
    public void testMapperFindOne() {
        Integer id = 1;
        OrderList orderList = orderListService.findById(id);
        System.out.println(JSON.toJSON(orderList));
    }

    @Test
    public void testServiceFindOne() {
        Integer id = 1;
        OrderList orderList = orderListService.findById(id);
        System.out.println(JSON.toJSON(orderList));
    }

}
