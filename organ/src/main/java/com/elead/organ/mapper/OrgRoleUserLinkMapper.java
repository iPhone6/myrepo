package com.elead.organ.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.OrgRoleUserLink;

/**
 * 角色和组织的中间表  与 用户关联
 * @author  wencz 
 * E-mail: wencz@e-lead.cn
 * @date 创建时间：2017年2月16日 下午3:43:38 
 * @version 1.0 
 * @company Elead
 */
@Mapper
public interface OrgRoleUserLinkMapper
{
	/**
	 * @描述（创建中间表OrgRoleUserLink 通用mybatis映射 OrgRoleUserLinkMapper.xml）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:44:45
	 * @parameter （orgRoleUserLink：中间表对象）
	 * @return 返回值
	 */
	int addOrgRoleUserLink(OrgRoleUserLink orgRoleUserLink);
	
	/**
	 * @描述（创建中间表OrgRoleUserLink）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:44:45
	 * @parameter （参数及其意义）
	 * @return 返回值
	 */
	@Update("update ms_orgroleuserlink set userid = #{orgRoleUserLink.userid}, relationid = #{orgRoleUserLink.relationid},remark = #{orgRoleUserLink.remark}, enabled = #{orgRoleUserLink.enabled}"
			+ " where id = #{orgRoleUserLink.id}")
	void updateOrgRoleUserLinkById(@Param("orgRoleUserLink") OrgRoleUserLink orgRoleUserLink);
	
	
	/**
	 * @描述（创建中间表OrgRoleUserLink）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:44:45
	 * @parameter （参数及其意义）
	 * @return 返回值
	 */
	@Update("update ms_orgroleuserlink set enabled = #{orgRoleUserLink.enabled} where id = #{orgRoleUserLink.id}")
	void deleteOrgRoleUserLinkById(@Param("orgRoleUserLink") OrgRoleUserLink orgRoleUserLink);
	
}
