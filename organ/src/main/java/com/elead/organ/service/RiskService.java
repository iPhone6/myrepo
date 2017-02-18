package com.elead.organ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elead.organ.mapper.RiskMapper;
import com.elead.organ.model.Risk;

/**
 * 风险service
 */
@Service
public class RiskService {
	@Autowired
	private RiskMapper riskMapper;
	
	/**
	 * 根据风险名查找此风险的详细信息
	 * @param name 风险名称
	 * @return
	 */
	public Risk findRisk(String name){
		return riskMapper.findRisk(name);
	}
	
	/**
	 * 根据status查找出所有的风险(传null则查询所有的)
	 * @return 所有的风险
	 */
	public List<Risk> findAllRisksByStatus(String status){
		return  riskMapper.findAllRisksByStatus(status);
	}
	
	/**
	 * 新增风险
	 * @param risk 风险实体
	 * @return 影响了几行
	 */
	@Transactional
	public int addRisk(Risk risk){
		return riskMapper.addRisk(risk);
	}
	
	/**
	 * 更新对应风险信息
	 * @param risk 风险实体
	 * @return 影响了几行
	 */
	@Transactional
	public int updateRisk(Risk risk){
		return riskMapper.updateRisk(risk);
	}
}
