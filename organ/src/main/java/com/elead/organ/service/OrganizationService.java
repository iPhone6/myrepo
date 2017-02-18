package com.elead.organ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elead.organ.mapper.OrganizationMapper;
import com.elead.organ.model.Organization;

/**
 * 组织service
 */
@Service
public class OrganizationService {
	@Autowired
	private OrganizationMapper organizationMapper;
	
	/**
	 * 根据用户名查找此组织的详细信息
	 * @param name 组织名称
	 * @return
	 */
	public Organization findOrganization(String name){
		return organizationMapper.findOrganization(name);
	}
	
	/**
	 * 新增组织
	 * @param org 组织实体
	 * @return 影响了几行
	 */
	@Transactional
	public int addOrganization(Organization org){
		return organizationMapper.addOrganization(org);
	}
	
	/**
	 * 更新对应组织信息
	 * @param org 组织实体
	 * @return 影响了几行
	 */
	@Transactional
	public int updateOrganization(Organization org){
		return organizationMapper.updateOrganization(org);
	}
	
	/**
	 * 删除对应的组织（实际只是改变enabled字段）
	 * @param id 组织id
	 * @return 影响了几行
	 */
	@Transactional
	public int deleteOrganization(int id){
		return organizationMapper.deleteOrganization(id);
	}
	
	/**
	 * 查找出所有的有效的组织
	 * @return
	 */
	public List<Organization> findAllEnabledOrganizations(){
		return organizationMapper.findAllEnabledOrganizations();
	}
}
