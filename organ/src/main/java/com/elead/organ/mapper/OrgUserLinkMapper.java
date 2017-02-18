package com.elead.organ.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.OrgUserLink;

/**
 * 组织和用户的中间表
 * @author  wencz 
 * E-mail: wencz@e-lead.cn
 * @date 创建时间：2017年2月16日 下午3:36:50 
 * @version 1.0 
 * @company Elead
 */
@Mapper //映射
public interface OrgUserLinkMapper
{
	
	/**
	 * 
	 * @描述（创建中间表，通用mybatis映射 OrgUserLinkMapper.xml）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:39:49
	 * @parameter （orgUserLink 对象）
	 * @return int成功与否
	 */
	int addOrgUserLink(OrgUserLink orgUserLink); 
	
	/**
	 * @描述（更新中间表（使用@Update注解指明update方法要执行的SQL ））
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:39:49
	 * @parameter （orgUserLink 对象）
	 */
	// 
	@Update("update ms_orguserlink set userid = #{orgUserLink.userid}, orgid = #{orgUserLink.orgid}, remark = #{orgUserLink.remark}, enabled = #{orgUserLink.enabled}"
			+ " where id = #{orgUserLink.id}")
	void updateOrgUserLinkById(@Param("orgUserLink") OrgUserLink orgUserLink);
	
	/**
	 * @描述（删除中间表（软删除））
	 * @author wencz
	 * @version 1.0
	 * @date 2017年2月16日 下午3:39:49
	 * @parameter （orgUserLink 对象）
	 */
	@Update("update ms_orguserlink set enabled = #{orgUserLink.enabled} where id = #{orgUserLink.id}")
	void deleteOrgUserLinkById(@Param("orgUserLink") OrgUserLink orgUserLink);
	
}
