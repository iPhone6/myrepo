package com.elead.organ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.Organization;

/**
 * 组织的mapper文件
 */
@Mapper
public interface OrganizationMapper {
	
	/**
	 * 根据用户名查找此组织的详细信息
	 * @param name 组织名称
	 * @return
	 */
	@Select("select * from ms_organization where name = #{name}")
	public Organization findOrganization(String name);
	
	/**
	 * 查找出所有的有效的组织
	 * @return 所有有效的组织
	 */
	public List<Organization> findAllEnabledOrganizations();
	
	/**
	 * 新增组织
	 * @param org 组织实体
	 * @return 影响了几行
	 */
//	@Insert("insert into ms_organization (name, parentid, sort, createDeptGroup, deptHiding, deptPerimits, userPerimits, outerDept, outerPermitDepts, outerPermitUsers)"
//			+ "values(#{org.name}, #{org.parentid}, #{org.sort}, #{org.createDeptGroup}, #{org.deptHiding}, #{org.deptPerimits}, #{org.userPerimits}, #{org.outerDept}, "
//			+ "#{org.outerPermitDepts}, #{org.outerPermitUsers})")
	public int addOrganization(Organization org);
	
	/**
	 * 更新对应组织信息
	 * @param org 组织实体
	 * @return 影响了几行
	 */
	@Update("update ms_organization set name = #{org.name}, parentid = #{org.parentid}, sort = #{org.sort}, createDeptGroup = #{org.createDeptGroup}, deptHiding = #{org.deptHiding}, "
			+ "deptPerimits = #{org.deptPerimits}, userPerimits = #{org.userPerimits}, outerDept = #{org.outerDept}, outerPermitDepts = #{org.outerPermitDepts}, outerPermitUsers = #{org.outerPermitUsers}"
			+ " where id = #{org.id}")
	public int updateOrganization(@Param("org") Organization org);
	
	/**
	 * 删除对应的组织（实际只是改变enabled字段）
	 * @param id 组织id
	 * @return 影响了几行
	 */
	@Update("update ms_organization set enabled = false where id = #{id}")
	public int deleteOrganization(int id);
	
}
