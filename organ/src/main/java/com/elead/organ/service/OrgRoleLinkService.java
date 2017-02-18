package com.elead.organ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.OrgRoleLinkMapper;
import com.elead.organ.model.OrgRoleLink;

/**
 * OrgRoleLink 操作的服务类
 * @author  wencz 
 * E-mail: wencz@e-lead.cn
 * @date 创建时间：2017年2月16日 下午3:48:13 
 * @version 1.0 
 * @company Elead
 */
@Service
public class OrgRoleLinkService
{
	@Autowired
	private OrgRoleLinkMapper roleLinkMapper; //注解与自动装配
	
	/**
	 * @描述（创建）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgRoleLink ： 对象）
	 */
	public int addOrgRoleLink(OrgRoleLink orgRoleLink) {
		return roleLinkMapper.addOrgRoleLink(orgRoleLink);
    }
	/**
	 * @描述（更新）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgRoleLink ： 对象）
	 */
	public void updateOrgRoleLink(OrgRoleLink orgRoleLink) {
		roleLinkMapper.updateOrgRoleLinkById(orgRoleLink);
    }
	/**
	 * @描述（删除）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgRoleLink ： 对象）
	 */
	public void deleteOrgRoleLinkById(OrgRoleLink orgRoleLink) {
		roleLinkMapper.deleteOrgRoleLinkById(orgRoleLink);
    }
}
