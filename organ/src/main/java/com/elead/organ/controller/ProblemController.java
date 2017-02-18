package com.elead.organ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.Problem;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.ProblemService;
import com.elead.organ.util.TextUtils;

/**
 * 问题controller(封装与问题有关的请求)
 */
@RestController
public class ProblemController extends BaseRequestResult{
	@Autowired
	 private ProblemService problemService;
	
	/**
	 * 根据问题名查找此问题的详细信息
	 * @param param json字符串，里面必须包含name字段
	 * @return 结果实体
	 */
	@RequestMapping(value = "/findProblem")
	public RequestResult findProblem(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		Problem problem = null;
		try {
			JSONObject object = JSON.parseObject(param);
			String name = object.getString("name");
			problem = problemService.findProblem(name);
			if(problem != null) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message,problem);
	}
	
	/**
	 * 根据status查找出所有的问题(传null则查询所有的)
	 * @return 结果实体
	 */
	@RequestMapping(value = "/findAllEnabledProblems")
	public RequestResult findAllProblemsByStatus(@RequestParam(value = "param", required = true) String param) {
		String code = "0" ;
		String message = "请求失败" ;
		List<Problem> problems = null;
		try {
			if (TextUtils.isEmpty(param) || !param.contains("status")) {
				problems = problemService.findAllProblemsByStatus(null);
			} else {
				JSONObject object = JSON.parseObject(param);
				String status = object.getString("status");
				problems = problemService.findAllProblemsByStatus(status);
				if (problems != null) {
					code = "1";
					message = "请求成功";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message , problems);
	}
	
	/**
	 * 新增单条问题
	 * @param param 问题的实体json字符串
	 * @return
	 */
	@RequestMapping(value = "/addProblem")
	public RequestResult addProblem(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name") || !param.contains("person_liable")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		Problem problem = null;
		try {
			problem = JSON.parseObject(param,Problem.class);
			int ret = problemService.addProblem(problem);
			if(ret > 0) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message , problem == null ?null : problem.getId());
	}
	
	/**
	 * 更新对应的单条问题数据
	 * @param param 问题的实体json字符串
	 * @return
	 */
	@RequestMapping(value = "/updateProblem")
	public RequestResult updateProblem(@RequestParam(value = "param", required = true) String param) {
		String code = "0" ;
		String message = "请求失败" ;
		Problem problem = null;
		try {
			problem = JSON.parseObject(param,Problem.class);
			int ret = problemService.updateProblem(problem);
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
