package com.elead.organ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.MsTaskLog;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.MsTaskLogService;

/**
 * 任务日志Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/msTaskLog")
public class MsTaskLogController extends BaseRequestResult {
	
	@Autowired
	private MsTaskLogService msTaskLogService;
	
	// 增加一条任务日志
	//		Json格式的param参数的格式：{"action":"登录", "operator":"李xx"}
	@RequestMapping("add")
	public RequestResult addMsTaskLog(@RequestParam(value = "param", required = true) String param) {
		String code = "0";
		String message = "请求失败";
		MsTaskLog ms_task_log = null;
		try {
			ms_task_log = JSON.parseObject(param, MsTaskLog.class);
		} catch (Exception e) {
			System.out.println("转换param参数为任务日志实体时出现异常");
		}
		
		if(ms_task_log != null) {
			int add_ret = msTaskLogService.addMsTaskLog(ms_task_log);
			if(add_ret > 0) {
				code = "1";
				message = "请求成功";
			}
		}
		
		return resultInfo(code, message, ms_task_log == null?null:ms_task_log.getId());
	}
	
	
	// 根据id查询任务日志
	// 		Json格式的param参数的格式：{"id":1}
	@RequestMapping("findById")
	public RequestResult findMsTaskLogById(String param) {
		String code = "0";
		String message = "请求失败";
		MsTaskLog task_log = null;
		
		JSONObject param_json = null;
		try {
			param_json = JSON.parseObject(param);
		} catch (Exception e) {
			System.out.println("转换param参数为Json对象时出现异常");
		}
		
		if(param_json != null) {
			Integer log_id = param_json.getInteger("id");
			if(log_id != null && log_id > 0) {
				task_log = msTaskLogService.queryMsTaskLogById(log_id);
				if(task_log != null) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("查询到的任务日志对象为空");
				}
			} else {
				System.out.println("参数id的值为null或非正数");
			}
		}
		
		return resultInfo(code, message, task_log);
	}
	
	
	
	// 根据日志类型查询任务日志
	// 		Json格式的param参数的格式：{"log_type":"Error"}
	@RequestMapping("findByLogType")
	public RequestResult findMsTaskLogByLogType(String param) {
		String code = "0";
		String message = "请求失败";
		List<MsTaskLog> task_logs = null;
		
		JSONObject param_json = null;
		try {
			param_json = JSON.parseObject(param);
		} catch (Exception e) {
			System.out.println("转换param参数为Json对象时出现异常");
		}
		
		if(param_json != null) {
			String log_type = param_json.getString("log_type");
			if(log_type != null) {
				task_logs = msTaskLogService.findMsTaskLogByLogType(log_type);
				if(task_logs != null && task_logs.size() > 0) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("查询到的任务日志列表为空");
				}
			} else {
				System.out.println("参数log_type的值为null");
			}
		}
		
		return resultInfo(code, message, task_logs);
	}
	
	
}
