package com.fitt.gbt.qbank.service;

import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.domain.Exercise;

import java.util.List;

/**
 * <p>@Description: 习题业务接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-28</p>
 * <p>@version: 1.0</p>
 */
public interface ExercisesService {
	/**
	 * 新增
	 *
	 * @param exercise
	 * @return
	 */
	Result add(Exercise exercise);

	/**
	 * 删除
	 *
	 * @param ids
	 * @return
	 */
	Result delete(List<Integer> ids);

	/**
	 * 修改
	 *
	 * @param exercise
	 * @return
	 */
	Result update(Exercise exercise);

	/**
	 * 查询列表
	 *
	 * @param category:所属分类: 0-练习题；1-历年真题；2-同学分享题
	 * @param type:类型:       0-单选题，1-多选题，2-判断改错题，3-简答题，4-案例分析，5-论文
	 * @param pageNo:        页码,第几页: 默认0第一页
	 * @param pageSize:      页容量, 每天多少条: 默认每页10条
	 * @return
	 */
	Result findAll(String category, String type, int pageNo, int pageSize);

	/**
	 * 查询列表
	 *
	 * @param category:所属分类: 0-练习题；1-历年真题；2-同学分享题
	 * @param type:类型:       0-单选题，1-多选题，2-判断改错题，3-简答题，4-案例分析，5-论文
	 * @param pageNo:        页码,第几页: 默认0第一页
	 * @param pageSize:      页容量, 每天多少条: 默认每页10条
	 * @return
	 */
	List<Exercise> list(String category, String type, int pageNo, int pageSize);

	/**
	 * 根据ID获取对象
	 * @param id
	 * @return
	 */
	Exercise findById(Integer id);

}
