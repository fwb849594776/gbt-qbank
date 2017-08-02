package com.fitt.gbt.qbank.service.impl;

import com.fitt.gbt.qbank.common.enums.StatusCodeEnum;
import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.common.utils.BeanUtil;
import com.fitt.gbt.qbank.common.utils.ResultUtil;
import com.fitt.gbt.qbank.domain.Exercise;
import com.fitt.gbt.qbank.repository.ExercisesRepository;
import com.fitt.gbt.qbank.service.ExercisesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>@Description: 习题业务实现类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-28</p>
 * <p>@version: 1.0</p>
 */
@Service
public class ExercisesServiceImpl implements ExercisesService {
	private static final Logger logger = LoggerFactory.getLogger(ExercisesServiceImpl.class);

	@Autowired
	private ExercisesRepository exercisesRepository;

	@Override
	public Result add(Exercise exercise) {
		Result<Exercise> result = ResultUtil.success();

		try {
			// 校验参数
			if (null == exercise || StringUtils.isEmpty(exercise.getQuestion())) {
				return ResultUtil.parameterMissing("question");
			}
			// 查询是否已经存在
			List<Exercise> exercisesList =
					exercisesRepository.findByCategoryAndTypeAndQuestion(exercise.getCategory(), exercise.getType(), exercise.getQuestion());
			if (null != exercisesList && !exercisesList.isEmpty()) {
				return ResultUtil.error(StatusCodeEnum.ERROR_DATA_EXISTED);
			}
			exercise.setCreateTime(new Date());
			result.setData(exercisesRepository.save(exercise));
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......findAll() occurred error!", e);
		}
		return result;
	}

	@Override
	public Result delete(List<Integer> ids) {
		Result result = ResultUtil.success();
		try {
			if (null == ids || ids.isEmpty()) {
				return ResultUtil.parameterMissing("id");
			}
			List<Exercise> exerciseList = exercisesRepository.findAll(ids);
			if (null == exerciseList || exerciseList.isEmpty()) {
				return ResultUtil.error(StatusCodeEnum.ERROR_DATA_NOT_EXISTED);
			}
			exercisesRepository.delete(exerciseList);
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......findAll() occurred error!", e);
		}
		return result;
	}

	@Override
	public Result<Exercise> update(Exercise exercise) {
		Result<Exercise> result = ResultUtil.success();

		try {
			if (null == exercise || StringUtils.isEmpty(exercise.getId())) {
				return ResultUtil.error(StatusCodeEnum.ERROR_REQUEST_FORMAT);
			}

			Exercise data = exercisesRepository.findOne(exercise.getId());
			if (null == data) {
				return ResultUtil.error(StatusCodeEnum.ERROR_DATA_NOT_EXISTED);
			}

			BeanUtil.copyProperties(exercise, data);

			exercisesRepository.saveAndFlush(data);

			result.setData(data);
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......findAll() occurred error!", e);
		}
		return result;
	}

	@Override
	public Result findAll(String category, String type, int pageNo, int pageSize) {
		Result result = ResultUtil.success();

		try {
			Pageable pageable = new PageRequest(pageNo, pageSize, Sort.Direction.ASC, "id");

			Page<Exercise> exercisePage = exercisesRepository.findAll(new Specification<Exercise>() {
				@Override
				public Predicate toPredicate(Root<Exercise> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
					List<Predicate> list = new ArrayList<Predicate>();
					if(!StringUtils.isEmpty(category)){
						list.add(criteriaBuilder.equal(root.get("category").as(Integer.class), Integer.valueOf(category)));
					}
					if(!StringUtils.isEmpty(type)){
						list.add(criteriaBuilder.equal(root.get("type").as(Integer.class), Integer.valueOf(type)));
					}
					Predicate[] predicates = new Predicate[list.size()];
					return criteriaBuilder.and(list.toArray(predicates));
				}
			}, pageable);

			result.setData(exercisePage);
		} catch (Exception e) {
			result = ResultUtil.error();
			logger.error("......findAll() occurred error!", e);
		}
		return result;
	}
}
