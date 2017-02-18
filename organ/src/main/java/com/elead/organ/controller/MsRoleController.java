package com.elead.organ.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.MsRole;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.MsRoleService;

// 角色控制器
@RestController
@RequestMapping("/msRole")
public class MsRoleController extends BaseRequestResult {
	
	@Autowired
	private MsRoleService msRoleService;
	
	// 根据角色id查询角色信息
	@RequestMapping("/findMsRoleByRoleId")
	public RequestResult findMsRoleByRoleId(@RequestParam("param") String param) {
		JSONObject param_json;
		
		try {
			param_json = JSON.parseObject(param);
		} catch (Exception e) {
			return resultInfo("0", "参数param转换成Json对象出现异常", null);
		}
		
		Integer roleId = param_json.getInteger("roleId");
		if(roleId == null) {
			return resultInfo("0", "参数roleId为null异常", null);
		}
		
		MsRole ms_role = msRoleService.findMsRoleByRoleId(roleId);
		if(ms_role == null) {
			return resultInfo("0", "查询失败", null);
		}
		
		return resultInfo("1", "查询成功", ms_role);
	}
	
	// 添加一个角色
	@RequestMapping("/addMsRole")
	public RequestResult addMsRole(String param) {
		MsRole param_json;
		
		try {
			param_json = JSON.parseObject(param, MsRole.class);
		} catch (Exception e) {
			return resultInfo("0", "参数param转换成Json对象出现异常", null);
		}
		
		int add_ret = msRoleService.addMsRole(param_json);
		
		if(add_ret > 0) {
			return resultInfo("1", "createdRole", null);
		} else {
			return resultInfo("0", "createdRole", null);
		}
	}
	
	// 添加一个角色并返回所创建的角色id
	@RequestMapping("/addMsRoleWithBackId")
	public RequestResult addMsRoleWithBackId(String param) {
		MsRole param_json;
		
		try {
			param_json = JSON.parseObject(param, MsRole.class);
		} catch (Exception e) {
			return resultInfo("0", "参数param转换成Json对象出现异常", null);
		}
		
		int add_ret = msRoleService.addMsRoleWithBackId(param_json);
		
		if(add_ret > 0) {
			return resultInfo("1", "createdRole", param_json.getRoleId());
		} else {
			return resultInfo("0", "createdRole", null);
		}
	}
	
	// 根据角色id修改角色信息
	@RequestMapping("/updateMsRole")
	public RequestResult updateMsRoleByRoleId(String param) {
		MsRole param_json;
		
		try {
			param_json = JSON.parseObject(param, MsRole.class);
		} catch (Exception e) {
			return resultInfo("0", "参数param转换成Json对象出现异常", null);
		}
		
		Integer roleId = param_json.getRoleId();
		String roleName = param_json.getRoleName();
		
		if(roleId == null || StringUtils.isBlank(roleName)) {
			return resultInfo("0", "参数roleId或roleName为空", null);
		}
		
		if(roleId <= 0) {
			return resultInfo("0", "参数roleId的值为负数或0异常", null);
		}
		
		int upd_ret = msRoleService.updateMsRoleByRoleId(param_json);
		if(upd_ret <= 0) {
			return resultInfo("0", "更新角色信息出现异常", null);
		} else {
			return resultInfo("1", "updatedRole", null);
		}
		
	}
	
	// 根据角色id删除一个角色
	@RequestMapping(value = "deleteMsRole", produces = "application/json; charset=utf-8")
	@ResponseBody()
	public RequestResult deleteMsRoleByRoleId(String param) {
		JSONObject param_json;
		
		try {
			param_json = JSON.parseObject(param);
		} catch (Exception e) {
			return resultInfo("0", "参数param转换成Json对象出现异常", null);
		}
		
		Integer roleId = param_json.getInteger("role_id");
		
		System.out.println("role_id = " + roleId);
		
		if(roleId == null || roleId <= 0) {
			return resultInfo("0", "参数role_id的值为null、0或负数异常", null);
		}
		
		int del_ret = msRoleService.deleteMsRoleByRoleId(roleId);
		if(del_ret <= 0) {
			return resultInfo("0", "删除role_id=" + roleId + "的角色信息出现异常", null);
		}
		
		return resultInfo("1", "deletedRole", null);
	}
	
	
	
}
