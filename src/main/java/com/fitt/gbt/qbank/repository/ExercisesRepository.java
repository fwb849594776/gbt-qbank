package com.fitt.gbt.qbank.repository;

import com.fitt.gbt.qbank.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>@Description: 习题数据操作模型</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-28</p>
 * <p>@version: 1.0</p>
 */
@Repository
public interface ExercisesRepository extends JpaRepository<Exercise, Integer>, JpaSpecificationExecutor<Exercise> {
	/**
	 * 根据 所属分类-类型-题目查询 习题列表
	 * @param category
	 * @param type
	 * @param question
	 * @return
	 */
	List<Exercise> findByCategoryAndTypeAndQuestion(Integer category, Integer type, String question);
}
