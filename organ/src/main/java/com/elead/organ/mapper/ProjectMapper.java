package com.elead.organ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.GroupUserInfo;
import com.elead.organ.model.Project;

@Mapper
public interface ProjectMapper {

	// @Select("select groupId,groupName,remark,enabled from ms_group where groupName = #{project.groupName}")
	List<Project> findProjectsList(@Param("project") Project project);

	@Select("select groupId,groupName,remark,enabled from ms_group where groupId = #{project.groupId}")
	Project projectById(@Param("project") Project project);

	@Select("select id from ms_group_user_info where group_id = #{groupUserInfo.group_id}"
			+ " and user_id = #{groupUserInfo.user_id}")
	GroupUserInfo GroupUserInfoByID(
			@Param("groupUserInfo") GroupUserInfo groupUserInfo);

	@Select("select groupId,groupName,remark,enabled from ms_group where groupName = #{project.groupName}")
	Project projectNameById(@Param("project") Project project);

	@Insert("insert into ms_group (groupName,remark,enabled)"
			+ " values (#{project.groupName},#{project.remark},#{project.enabled})")
	int insertProject(@Param("project") Project project);

	@Insert("insert into ms_group_user_info (group_id,user_id)"
			+ " values (#{groupUserInfo.group_id},#{groupUserInfo.user_id})")
	int insertGroupUserInfo(@Param("groupUserInfo") GroupUserInfo groupUserInfo);

	@Update("update ms_group set groupName = #{project.groupName} where groupId = #{project.groupId}")
	int updateProject(@Param("project") Project project);

	@Update("update ms_group_user_info set user_id = #{groupUserInfo.user_id} "
			+ " where group_id = #{groupUserInfo.group_id} and user_id = #{groupUserInfo.user_id}")
	int updateGroupUserInfo(@Param("groupUserInfo") GroupUserInfo groupUserInfo);

	// @Delete("delete from ms_group where groupId = #{groupId}")
	int deleteProject(@Param("project") Project project);

	@Delete("delete from ms_group_user_info where group_id = #{groupId}")
	int deleteGroupUserInfo(@Param("groupId") Long groupId);
}
