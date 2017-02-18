package com.elead.organ.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.OrgRoleLink;

/**
 * 角色和组织的中间表
 * @author  wencz 
 * E-mail: wencz@e-lead.cn
 * @date 创建时间：2017年2月16日 下午3:36:13 
 * @version 1.0 
 * @company Elead
 */
@Mapper //映射
public interface OrgRoleLinkMapper
{	
	/**
	 * 
	 * @描述（创建中间表OrgRoleLink 通用mybatis映射 OrgRoleLinkMapper.xml）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:37:33
	 * @parameter （orgRoleLink 对象属性）
	 */
	int addOrgRoleLink(OrgRoleLink orgRoleLink);
	
	/**
	 * 
	 * @描述（更新中间表 （使用@Update注解指明update方法要执行的SQL ））
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:38:16
	 * @parameter （orgRoleLink ： 对象属性）
	 */
	@Update("update ms_orgrolelink set relationid = #{orgRoleLink.relationid}, orgid = #{orgRoleLink.orgid}, roleid = #{orgRoleLink.roleid}, remark = #{orgRoleLink.remark}, enabled = #{orgRoleLink.enabled}"
			+ " where relationid = #{orgRoleLink.relationid}")
	void updateOrgRoleLinkById(@Param("orgRoleLink") OrgRoleLink orgRoleLink);
	
	/**
	 * 
	 * @描述（删除中间表（软删除））
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:38:22
	 * @parameter （orgRoleLink ： 对象属性）
	 */
	@Update("update ms_orgrolelink set enabled = #{orgRoleLink.enabled} where relationid = #{orgRoleLink.relationid}")
	void deleteOrgRoleLinkById(@Param("orgRoleLink") OrgRoleLink orgRoleLink);
	
}
