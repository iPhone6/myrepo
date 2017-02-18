package com.elead.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.MsApplication;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.MsApplicationService;

/**
 * 应用Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/msApplication")
public class MsApplicationController extends BaseRequestResult {
	
	@Autowired
	private MsApplicationService msApplicationService;
	
	
	// 增加一个应用
	//		Json格式的param参数的格式：{"type":"xx", "identification":"xx"}
	@RequestMapping("add")
	public RequestResult addMsApplication(String param) {
		String code = "0";
		String message = "请求失败";
		MsApplication ma = null;
		try {
			ma = JSON.parseObject(param, MsApplication.class);
		} catch (Exception e) {
			System.out.println("参数param转换成应用对象出现异常");
		}
		
		if(ma != null) {
			int add_ret = msApplicationService.addMsApplication(ma);
			if(add_ret > 0) {
				code = "1";
				message = "请求成功";
			} else {
				System.out.println("添加应用异常");
			}
		} else {
			System.out.println("应用对象为null异常");
		}
		
		return resultInfo(code, message, ma == null?null:ma.getId());
	}
	
	
	// 删除一个应用
	//		Json格式的param参数的格式：{"id":xx}
	@RequestMapping("delete")
	public RequestResult deleteMsApplicationById(String param) {
		String code = "0";
		String message = "请求失败";
		JSONObject param_json = null;
		
		try {
			param_json = JSON.parseObject(param);
		} catch (Exception e) {
			System.out.println("参数param转换成Json对象出现异常");
		}
		
		if(param_json != null) {
			Integer ma_id = param_json.getInteger("id");
			
			if(ma_id != null) {
				int del_ret = msApplicationService.deleteMsApplicationById(ma_id);
				if(del_ret > 0) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("删除应用异常");
				}
			} else {
				System.out.println("应用id参数为null异常");
			}
		} else {
			System.out.println("参数为null异常");
		}
		
		return resultInfo(code, message, null);
	}
	
	
	// 修改一个应用
	//		Json格式的param参数的格式：{"id":xx}
	@RequestMapping("update")
	public RequestResult updateMsApplicationById(String param) {
		String code = "0";
		String message = "请求失败";
		MsApplication ma = null;
		try {
			ma = JSON.parseObject(param, MsApplication.class);
		} catch (Exception e) {
			System.out.println("参数param转换成应用对象出现异常");
		}
		
		if(ma != null) {
			if(ma.getId() != null) {
				int upd_ret = msApplicationService.updateMsApplicationById(ma);
				if(upd_ret > 0) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("修改应用信息失败");
				}
			} else {
				System.out.println("应用对象的id为null异常");
			}
		} else {
			System.out.println("应用对象为null异常");
		}
		
		return resultInfo(code, message, null);
	}
	
	
	// 查找一个应用
	//		Json格式的param参数的格式：{"id":xx}
	@RequestMapping("find")
	public RequestResult findMsApplicationById(String param) {
		String code = "0";
		String message = "请求失败";
		JSONObject param_json = null;
		
		try {
			param_json = JSON.parseObject(param);
		} catch (Exception e) {
			System.out.println("参数param转换成Json对象出现异常");
		}
		
		Integer ma_id = null;
		try {
			ma_id = param_json.getInteger("id");
		} catch (Exception e) {
			System.out.println("参数id转成整数出现异常");
		}
		MsApplication ma_ret = null;
		
		if(ma_id != null) {
			ma_ret = msApplicationService.findMsApplicationById(ma_id);
			if(ma_ret != null) {
				code = "1";
				message = "请求成功";
			} else {
				System.out.println("查询到的应用信息为null异常");
			}
		} else {
			System.out.println("应用id为null异常");
		}
		
		return resultInfo(code, message, ma_ret);
	}
	
	
}
