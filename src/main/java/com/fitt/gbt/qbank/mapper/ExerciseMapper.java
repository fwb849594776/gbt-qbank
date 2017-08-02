package com.fitt.gbt.qbank.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fitt.gbt.qbank.domain.Exercise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>@Description: 习题数据Mybatis操作接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-31</p>
 * <p>@version: 1.0</p>
 */
public interface ExerciseMapper extends BaseMapper<Exercise> {
	/**
	 * 分页查询
	 * @param category
	 * @param type
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Exercise> findByPage(@Param("category") Integer category,
							  @Param("type") Integer type,
							  @Param("offset") int offset,
							  @Param("rows") int rows);
}
