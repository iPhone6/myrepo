package com.elead.organ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.Organization;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.OrganizationService;

/**
 * 组织controller(封装与组织有关的请求)
 */
@RestController
public class OrganizationController extends BaseRequestResult{
	@Autowired
	 private OrganizationService organizationService;
	
	/**
	 * 根据用户名查找此组织的详细信息
	 * @param param json字符串，里面必须包含name字段
	 * @return 结果实体
	 */
	@RequestMapping(value = "/findOrganization")
	public RequestResult findOrganization(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		Organization organization = null;
		try {
			JSONObject object = JSON.parseObject(param);
			String name = object.getString("name");
			organization = organizationService.findOrganization(name);
			if(organization != null) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message,organization);
	}
	
	/**
	 * 查找出所有的有效的组织
	 * @return 结果实体
	 */
	@RequestMapping(value = "/findAllEnabledOrganizations")
	public RequestResult findAllEnabledOrganizations() {
		String code = "0" ;
		String message = "请求失败" ;
		List<Organization> organizations = null;
		try {
			organizations = organizationService.findAllEnabledOrganizations();
			if(organizations != null) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message , organizations);
	}
	
	/**
	 * 新增单条组织
	 * @param param 组织的实体json字符串
	 * @return
	 */
	@RequestMapping(value = "/addOrganization")
	public RequestResult addOrganization(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name") || !param.contains("parentid")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		Organization organization = null;
		try {
			organization = JSON.parseObject(param,Organization.class);
			int ret = organizationService.addOrganization(organization);
			if(ret > 0) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message , organization == null ?null : organization.getId());
	}
	
	/**
	 * 更新对应的单条组织数据
	 * @param param 组织的实体json字符串
	 * @return
	 */
	@RequestMapping(value = "/updateOrganization")
	public RequestResult updateOrganization(@RequestParam(value = "param", required = true) String param) {
		String code = "0" ;
		String message = "请求失败" ;
		Organization organization = null;
		try {
			organization = JSON.parseObject(param,Organization.class);
			int ret = organizationService.updateOrganization(organization);
			if(ret > 0) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message,null);
	}
	
	/**
	 * 删除对应的组织数据（实际只是将此条数据改为无效）
	 * @param param  json字符串，里面必须包含id字段
	 * @return
	 */
	@RequestMapping(value = "/deleteOrganization")
	public RequestResult deleteOrganization(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("id")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		try {
			JSONObject object = JSON.parseObject(param);
			int id = object.getIntValue("id");
			int ret = organizationService.deleteOrganization(id);
			if(ret > 0) {
				code="1";
				message = "请求成功" ;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message, null);
	}
}
