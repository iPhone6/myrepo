package com.elead.organ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.Problem;

/**
 * 问题的mapper文件
 */
@Mapper
public interface ProblemMapper {
	
	/**
	 * 根据问题名查找此问题的详细信息
	 * @param name 问题名称
	 * @return
	 */
	@Select("select * from ms_problem where name = #{name}")
	public Problem findProblem(String name);
	
	/**
	 * 根据status查找出所有的问题(传null则查询所有的)
	 * @return 所有的问题
	 */
	public List<Problem> findAllProblemsByStatus(@Param("status")String status);
	
	/**
	 * 新增问题
	 * @param problem 问题实体
	 * @return 影响了几行
	 */
	public int addProblem(Problem problem);
	
	/**
	 * 更新对应问题信息
	 * @param problem 问题实体
	 * @return 影响了几行
	 */
	@Update("update ms_problem set name = #{problem.name}, description = #{problem.description}, type_problem = #{problem.type_problem}, planned_completion_time = #{problem.planned_completion_time}, priority = #{problem.priority}, "
			+ "response_measures = #{problem.response_measures}, present_people = #{problem.present_people}, person_liable = #{problem.person_liable}, actual_completion_time = #{problem.actual_completion_time}, status = #{problem.status}"
			+ " where id = #{problem.id}")
	public int updateProblem(@Param("problem") Problem problem);
}
