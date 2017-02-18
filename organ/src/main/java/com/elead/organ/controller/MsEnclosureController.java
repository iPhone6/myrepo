package com.elead.organ.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.MsEnclosure;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.MsEnclosureService;

/**
 * 附件Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/msEnclosure")
public class MsEnclosureController extends BaseRequestResult {
	
	@Autowired
	private MsEnclosureService msEnclosureService;
	
	
	// 增加一个附件
	//		Json格式的param参数的格式：{"name":"xx", "description":"xx"}
	@RequestMapping("add")
	public RequestResult addMsEnclosure(String param) {
		String code = "0";
		String message = "请求失败";
		MsEnclosure me = null;
		try {
			me = JSON.parseObject(param, MsEnclosure.class);
		} catch (Exception e) {
			System.out.println("参数param转换成附件对象出现异常");
		}
		
		if(me != null) {
			if(StringUtils.isBlank(me.getName())) {
				System.out.println("附件的名称为空异常");
			} else {
				int add_ret = msEnclosureService.addMsEnclosure(me);
				if(add_ret > 0) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("添加附件出现异常");
				}
			}
		} else {
			System.out.println("附件对象为null异常");
		}
		
		return resultInfo(code, message, me == null?null:me.getId());
	}
	
	
	// 删除一个附件
	//		Json格式的param参数的格式：{"id":xx}
	@RequestMapping("delete")
	public RequestResult deleteMsEnclosureById(String param) {
		String code = "0";
		String message = "请求失败";
		MsEnclosure me = null;
		try {
			me = JSON.parseObject(param, MsEnclosure.class);
		} catch (Exception e) {
			System.out.println("参数param转换成附件对象出现异常");
		}
		
		if(me != null) {
			Integer me_id = me.getId();
			if(me_id != null) {
				int del_ret = msEnclosureService.deleteMsEnclosureById(me_id);
				if(del_ret > 0) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("删除附件失败");
				}
			} else {
				System.out.println("参数id为null异常");
			}
		} else {
			System.out.println("参数对象为null异常");
		}
		
		return resultInfo(code, message, null);
	}
	
	
	// 修改一个附件
	//		Json格式的param参数的格式：{"id":xx, "name":"xx", "description":"xx"}
	@RequestMapping("update")
	public RequestResult updateMsEnclosureById(String param) {
		String code = "0";
		String message = "请求失败";
		MsEnclosure me = null;
		try {
			me = JSON.parseObject(param, MsEnclosure.class);
		} catch (Exception e) {
			System.out.println("参数param转换成附件对象出现异常");
		}
		
		if(me != null) {
			if(me.getId() != null) {
				int upd_ret = msEnclosureService.updateMsEnclosureById(me);
				if(upd_ret > 0) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("修改附件信息失败");
				}
			} else {
				System.out.println("参数id为null异常");
			}
		} else {
			System.out.println("附件参数对象为null异常");
		}
		
		return resultInfo(code, message, null);
	}
	
	
	// 查找一个附件
	//		Json格式的param参数的格式：{"id":xx}
	@RequestMapping("find")
	public RequestResult findMsEnclosureById(String param) {
		String code = "0";
		String message = "请求失败";
		MsEnclosure param_me = null;
		try {
			param_me = JSON.parseObject(param, MsEnclosure.class);
		} catch (Exception e) {
			System.out.println("参数param转换成附件对象出现异常");
		}
		
		MsEnclosure me = null;
		if(param_me != null) {
			Integer me_id = param_me.getId();
			if(me_id != null) {
				me = msEnclosureService.findMsEnclosureById(me_id);
				if(me != null) {
					code = "1";
					message = "请求成功";
				} else {
					System.out.println("查询到的附件信息为null异常");
				}
			} else {
				System.out.println("参数id为null异常");
			}
		} else {
			System.out.println("参数对象为null异常");
		}
		
		return resultInfo(code, message, me);
	}
	
	
}
