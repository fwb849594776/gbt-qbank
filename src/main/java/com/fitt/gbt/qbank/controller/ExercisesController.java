package com.fitt.gbt.qbank.controller;

import com.fitt.gbt.qbank.common.enums.QuestionsEnum;
import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.domain.Exercise;
import com.fitt.gbt.qbank.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>@Description: 系统前端控制类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-28</p>
 * <p>@version: 1.0</p>
 */
@Controller
@RequestMapping(value = "exercise")
public class ExercisesController {
	@Autowired
	private ExercisesService exercisesService;

	@PostMapping
	@ResponseBody
	public Result add(@RequestBody Exercise exercise) {
		return exercisesService.add(exercise);
	}

	@DeleteMapping
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
	}

	@GetMapping(value = "test/paper")
	public String getTestPaper(Model model) {
		List<Exercise> radioList = exercisesService.list(null, QuestionsEnum.TYPE_RADIO.typeString(), 0, 40);//40
		List<Exercise> multiList = exercisesService.list(null, QuestionsEnum.TYPE_MULTI.typeString(), 0, 30);//40
		List<Exercise> judgeList = exercisesService.list(null, QuestionsEnum.TYPE_JUDGE.typeString(), 0, 10);//20
		List<Exercise> shortList = exercisesService.list(null, QuestionsEnum.TYPE_SHORT.typeString(), 0, 3);// 5
		List<Exercise> caseList = exercisesService.list(null, QuestionsEnum.TYPE_CASE.typeString(), 0, 2);// 5
		model.addAttribute("radioList", radioList);
		model.addAttribute("multiList", multiList);
		model.addAttribute("judgeList", judgeList);
		model.addAttribute("shortList", shortList);
		model.addAttribute("caseList", caseList);
		return "exercises/exercise";
	}
}
