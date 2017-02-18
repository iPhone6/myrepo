package com.elead.organ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.OrgUserLinkMapper;
import com.elead.organ.model.OrgUserLink;

/**
 * OrgUserLink 服务类
 * @author  wencz 
 * E-mail: wencz@e-lead.cn
 * @date 创建时间：2017年2月16日 下午4:02:09 
 * @version 1.0 
 * @company Elead
 */
@Service
public class OrgUserLinkService
{
	@Autowired
	private OrgUserLinkMapper orgUserLinkMapper;
	
	/**
	 * @描述（创建）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgUserLink ： 对象）
	 */
	public int addOrgUserLink(OrgUserLink orgUserLink) {
		return orgUserLinkMapper.addOrgUserLink(orgUserLink);
    }
	
	/**
	 * @描述（更新）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgUserLink ： 对象）
	 */
	public void updateOrgUserLinkById(OrgUserLink orgUserLink) {
		orgUserLinkMapper.updateOrgUserLinkById(orgUserLink);
    }
	
	/**
	 * @描述（删除）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:48:42
	 * @parameter （orgUserLink ： 对象）
	 */
	public void deleteOrgUserLinkById(OrgUserLink orgUserLink) {
		orgUserLinkMapper.deleteOrgUserLinkById(orgUserLink);
    }
}
