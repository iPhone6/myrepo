package com.elead.organ.daotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elead.organ.mapper.MsRoleMapper;
import com.elead.organ.mapper.UserMapper;
import com.elead.organ.model.MsRole;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:application.properties"})
public class TestMsRoleDao {
	
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private MsRoleMapper msRoleMapper;
	
	
	@Test
	public void testAddMsRoleWithBackId() {
		
		MsRole mr = new MsRole();
		
		mr.setRoleName("mm世世代代");
//		mr.setIsHide(false);
		
		int add_ret = msRoleMapper.addMsRoleWithBackId(mr);
		
		System.out.println("add_ret = " + add_ret);
		
	}
	
	
}
