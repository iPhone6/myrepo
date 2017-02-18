package com.elead.organ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.MsRoleMapper;
import com.elead.organ.model.MsRole;

@Service
public class MsRoleService {
	
	@Autowired
	private MsRoleMapper msRoleMapper;
	
	public MsRole findMsRoleByRoleId(Integer roleId) {
		return msRoleMapper.findMsRoleByRoleId(roleId);
	}
	
	public int addMsRole(MsRole msRole) {
		return msRoleMapper.addMsRole(msRole);
	}
	
	public int addMsRoleWithBackId(MsRole msRole) {
		System.out.println("添加前，roleId = " + msRole.getRoleId());
		int add_ret = msRoleMapper.addMsRoleWithBackId(msRole);
		System.out.println("添加后，roleId = " + msRole.getRoleId());
		return add_ret;
	}
	
	public int updateMsRoleByRoleId(MsRole msRole) {
		return msRoleMapper.updateMsRoleByRoleId(msRole);
	}
	
	public int deleteMsRoleByRoleId(Integer roleId) {
		return msRoleMapper.deleteMsRoleByRoleId(roleId);
	}
}
