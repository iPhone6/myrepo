package com.elead.organ.mapper;

import org.apache.ibatis.annotations.*;

import com.alibaba.fastjson.JSONObject;
import com.elead.organ.model.MsRole;

@Mapper
public interface MsRoleMapper {
	
	@Select("select * from ms_role where roleId = #{roleId}")
	MsRole findMsRoleByRoleId(Integer roleId);
	
	@Insert("insert into ms_role (roleName, remark, enabled) values(#{roleName}, #{remark}, #{enabled})")
	int addMsRole(MsRole msRole);
	
	int addMsRoleWithBackId(MsRole msRole);
	
	int updateMsRoleByRoleId(MsRole msRole);
	
	int deleteMsRoleByRoleId(Integer roleId);
	
}
