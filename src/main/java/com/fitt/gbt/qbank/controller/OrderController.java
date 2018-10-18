package com.fitt.gbt.qbank.controller;

import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.common.utils.ResultUtil;
import com.fitt.gbt.qbank.domain.Order;
import com.fitt.gbt.qbank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 订单表 前端控制器 </p>
 *
 * @author SixAwn
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseBody
    public Result add(@RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public Result findById(@PathVariable("id") Integer id) {
        Order orderList = orderService.findById(id);
        return ResultUtil.success(orderList);
    }

    @DeleteMapping
    @ResponseBody
    public Result delete(@RequestBody List<Integer> ids) {
        return orderService.delete(ids);
    }

    @PutMapping
    @ResponseBody
    public Result update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @GetMapping
    @ResponseBody
    public Result findAll(@RequestParam(value = "username", required = false) String username,
                          @RequestParam(value = "telephone", required = false) String telephone,
                          @RequestParam(value = "page_no", defaultValue = "0") int pageNo,
                          @RequestParam(value = "page_size", defaultValue = "10") int pageSize) {

        return orderService.findAll(username, telephone, pageNo, pageSize);
    }

    @GetMapping(value = "list")
    public String listPage(ModelMap modelMap) {
        List<Order> exerciseList = orderService.list(null, null, 0, 10);

        modelMap.put("dataList", exerciseList);
        modelMap.put("name", "每日一练");
        return "exercises/list";
    }

    @GetMapping(value = "{id}")
    public String findById(Model model, @PathVariable("id") Integer id) {
        Order order = orderService.findById(id);

        model.addAttribute("data", order);
        return "order/edit";
    }

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        System.out.println("hello=hello");
        map.put("hello", "封疆大吏");
        return "order/index";
    }

    @RequestMapping("/list")
    public ModelAndView showCities() {

        List<Order> orderList = orderService.findAll();

        Map<String, Object> params = new HashMap<>();
        params.put("orderList", orderList);

        return new ModelAndView("order/list", params);
    }

}
