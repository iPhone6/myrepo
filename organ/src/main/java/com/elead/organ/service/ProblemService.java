package com.elead.organ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elead.organ.mapper.ProblemMapper;
import com.elead.organ.model.Problem;

/**
 * 问题service
 */
@Service
public class ProblemService {
	@Autowired
	private ProblemMapper problemMapper;
	
	/**
	 * 根据问题名查找此问题的详细信息
	 * @param name 问题名称
	 * @return
	 */
	public Problem findProblem(String name){
		return problemMapper.findProblem(name);
	}
	
	/**
	 * 根据status查找出所有的问题(传null则查询所有的)
	 * @return 所有的问题
	 */
	public List<Problem> findAllProblemsByStatus(String status){
		return  problemMapper.findAllProblemsByStatus(status);
	}
	
	/**
	 * 新增问题
	 * @param problem 问题实体
	 * @return 影响了几行
	 */
	@Transactional
	public int addProblem(Problem problem){
		return problemMapper.addProblem(problem);
	}
	
	/**
	 * 更新对应问题信息
	 * @param problem 问题实体
	 * @return 影响了几行
	 */
	@Transactional
	public int updateProblem(Problem problem){
		return problemMapper.updateProblem(problem);
	}
}
