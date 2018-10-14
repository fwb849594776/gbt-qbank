package com.fitt.gbt.qbank.controller;

import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.common.utils.ResultUtil;
import com.fitt.gbt.qbank.domain.Order;
import com.fitt.gbt.qbank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    /*@@PostMapping
    @ResponseBody
    public Result add(@RequestBody Exercise exercise) {
        return exercisesService.add(exercise);
    }

    DeleteMapping
    @ResponseBody
    public Result delete(@RequestBody List<Integer> ids) {
        return exercisesService.delete(ids);
    }

    @PutMapping
    @ResponseBody
    public Result update(@RequestBody Exercise exercise) {
        return exercisesService.update(exercise);
    }

    @GetMapping
    @ResponseBody
    public Result findAll(@RequestParam(value = "category", required = false) String category,
                          @RequestParam(value = "category", required = false) String type,
                          @RequestParam(value = "page_no", defaultValue = "0") int pageNo,
                          @RequestParam(value = "page_size", defaultValue = "10") int pageSize) {

        return exercisesService.findAll(category, type, pageNo, pageSize);
    }

    @GetMapping(value = "list")
    public String listPage(ModelMap modelMap) {
        List<Exercise> exerciseList = exercisesService.list(null, null, 0, 10);

        modelMap.put("dataList", exerciseList);
        modelMap.put("name", "每日一练");
        return "exercises/list";
    }

    @GetMapping(value = "{id}")
    public String findById(Model model, @PathVariable("id") Integer id) {
        Exercise exercise = exercisesService.findById(id);

        model.addAttribute("data", exercise);
        return "exercises/edit";
    }*/

}
