package com.elead.organ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.Risk;

/**
 * 风险的mapper文件
 */
@Mapper
public interface RiskMapper {
	
	/**
	 * 根据风险名查找此风险的详细信息
	 * @param name 风险名称
	 * @return
	 */
	@Select("select * from ms_risk where name = #{name}")
	public Risk findRisk(String name);
	
	/**
	 * 根据status查找出所有的风险(传null则查询所有的)
	 * @return 所有的风险
	 */
	public List<Risk> findAllRisksByStatus(@Param("status")String status);
	
	/**
	 * 新增风险
	 * @param risk 风险实体
	 * @return 影响了几行
	 */
	public int addRisk(Risk risk);
	
	/**
	 * 更新对应风险信息
	 * @param risk 风险实体
	 * @return 影响了几行
	 */
	@Update("update ms_risk set name = #{risk.name}, description = #{risk.description}, type_risk = #{risk.type_risk}, planned_completion_time = #{risk.planned_completion_time}, priority = #{risk.priority}, "
			+ "response_measures = #{risk.response_measures}, present_people = #{risk.present_people}, person_liable = #{risk.person_liable}, actual_completion_time = #{risk.actual_completion_time}, status = #{risk.status}"
			+ " where id = #{risk.id}")
	public int updateRisk(@Param("risk") Risk risk);
}
