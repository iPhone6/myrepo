package com.elead.organ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.Risk;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.RiskService;
import com.elead.organ.util.TextUtils;

/**
 * 风险controller(封装与风险有关的请求)
 */
@RestController
public class RiskController extends BaseRequestResult{
	@Autowired
	 private RiskService riskService;
	
	/**
	 * 根据风险名查找此风险的详细信息
	 * @param param json字符串，里面必须包含name字段
	 * @return 结果实体
	 */
	@RequestMapping(value = "/findRisk")
	public RequestResult findRisk(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		Risk risk = null;
		try {
			JSONObject object = JSON.parseObject(param);
			String name = object.getString("name");
			risk = riskService.findRisk(name);
			if(risk != null) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message,risk);
	}
	
	/**
	 * 根据status查找出所有的风险(传null则查询所有的)
	 * @return 结果实体
	 */
	@RequestMapping(value = "/findAllEnabledRisks")
	public RequestResult findAllRisksByStatus(@RequestParam(value = "param", required = true) String param) {
		String code = "0" ;
		String message = "请求失败" ;
		List<Risk> risks = null;
		try {
			System.out.println(param);
			if(TextUtils.isEmpty(param) || !param.contains("status")){
				risks = riskService.findAllRisksByStatus(null);
			}else{
				JSONObject object = JSON.parseObject(param);
				String status = object.getString("status");
				risks = riskService.findAllRisksByStatus(status);
			}
			if(risks != null) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message , risks);
	}
	
	/**
	 * 新增单条风险
	 * @param param 风险的实体json字符串
	 * @return
	 */
	@RequestMapping(value = "/addRisk")
	public RequestResult addRisk(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name") || !param.contains("person_liable")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		Risk risk = null;
		try {
			risk = JSON.parseObject(param,Risk.class);
			int ret = riskService.addRisk(risk);
			if(ret > 0) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message , risk == null ?null : risk.getId());
	}
	
	/**
	 * 更新对应的单条风险数据
	 * @param param 风险的实体json字符串
	 * @return
	 */
	@RequestMapping(value = "/updateRisk")
	public RequestResult updateRisk(@RequestParam(value = "param", required = true) String param) {
		String code = "0" ;
		String message = "请求失败" ;
		Risk risk = null;
		try {
			risk = JSON.parseObject(param,Risk.class);
			int ret = riskService.updateRisk(risk);
			if(ret > 0) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message,null);
	}
}
