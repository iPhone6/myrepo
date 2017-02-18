package com.elead.organ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.OrgRoleUserLinkMapper;
import com.elead.organ.model.OrgRoleUserLink;

/**
 * OrgRoleUserLink 服务类
 * @author  wencz 
 * E-mail: wencz@e-lead.cn
 * @date 创建时间：2017年2月16日 下午3:50:27 
 * @version 1.0 
 * @company Elead
 */
@Service
public class OrgRoleUserLinkService
{

	@Autowired
	private OrgRoleUserLinkMapper orgRoleUserLinkMapper;//注解与自动装配
	
	/**
	 * @描述（创建）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgRoleUserLink ： 对象）
	 */
	public int addOrgRoleLink(OrgRoleUserLink orgRoleUserLink) {
		return orgRoleUserLinkMapper.addOrgRoleUserLink(orgRoleUserLink);
    }
	
	/**
	 * @描述（更新）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgRoleUserLink ： 对象）
	 */
	public void updateOrgRoleLink(OrgRoleUserLink orgRoleUserLink) {
		orgRoleUserLinkMapper.updateOrgRoleUserLinkById(orgRoleUserLink);
    }
	
	/**
	 * @描述（删除）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgRoleUserLink ： 对象）
	 */
	public void deleteOrgRoleUserLinkById(OrgRoleUserLink orgRoleUserLink) {
		orgRoleUserLinkMapper.deleteOrgRoleUserLinkById(orgRoleUserLink);
    }
}
