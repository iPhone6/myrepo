package com.elead.organ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.RequestResult;
import com.elead.organ.model.User;
import com.elead.organ.service.UserService;

/**
 * 人员controller(封装与人员有关的请求)
 */
@RestController
public class UserController extends BaseRequestResult{
	@Autowired
	private UserService userService;
	
	/**
	 * 根据用户id查找用户信息
	 * @param param json字符串，里面必须包含id字段
	 * @return 请求结果实体
	 */
	@RequestMapping(value = "/findUserById")
	public RequestResult findUserById(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("id")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		User user = null;
		try {
			JSONObject object = JSON.parseObject(param);
			long id = object.getLongValue("id");
			user = userService.findUserById(id);
			if(user != null){
				code="1";
				message = "请求成功" ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message, user);
	}
	
	/**
	 * 查找出所有的有效用户
	 * @return 请求结果实体
	 */
	@RequestMapping(value = "/findAllEnabledUsers")
	public RequestResult findAllEnabledUsers() {
		String code = "0" ;
		String message = "请求失败" ;
		List<User> enabledUsers = null;
		try {
			enabledUsers = userService.findAllEnabledUsers();
			if(enabledUsers != null){
				code="1";
				message = "请求成功" ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message, enabledUsers);
	}
	
	/**
	 * 新增用户
	 * @param param 用户json字符串
	 * @return 请求结果实体
	 */
	@RequestMapping(value = "/addUser")
	public RequestResult addUser(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("name") || !param.contains("mobile")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		User user = null;
		try {
			user = JSON.parseObject(param,User.class);
			int ret = userService.addUser(user);
			if(ret > 0) {
				code = "1";
				message = "请求成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message, user == null ? null : user.getId());
	}
	
	/**
	 * 更新对应的用户信息
	 * @param param json字符串,里面必须包含名字，电话号码，id
	 * @return 请求结果实体
	 */
	@RequestMapping(value = "updateUserById")
	public RequestResult updateUserById(@RequestParam(value = "param", required = true) String param) {
		String code = "0" ;
		String message = "请求失败" ;
		try {
			User user = JSON.parseObject(param,User.class);
			int ret = userService.updateUserById(user);
			if(ret > 0) {
				code = "1";
				message = "请求成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInfo(code, message, null);
	}
	
	/**
	 * 根据id删除对应的用户信息（实际只是修改状态）
	 * @param param json字符串,里面必须包含id
	 * @return
	 */
	@RequestMapping(value = "/deleteUserById")
	public RequestResult deleteUserById(@RequestParam(value = "param", required = true) String param) {
		if(param  == null || !param.contains("id")){
			return resultInfo("0", "请求失败" , null);
		}
		
		String code = "0" ;
		String message = "请求失败" ;
		try {
			JSONObject object = JSON.parseObject(param);
			long id = object.getLongValue("id");
			int ret = userService.deleteUserById(id);
			if(ret > 0) {
				code = "1";
				message = "请求成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultInfo(code, message, null);
	}
}
