package com.elead.organ.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.ProjectMapper;
import com.elead.organ.model.GroupUserInfo;
import com.elead.organ.model.Project;

@Service
public class ProjectService {
	@Autowired
	private ProjectMapper projectMapper;

	// 查询所有项目或根据项目里字段进行筛选数据
	public List<Project> findProjectsList(@Param("project") Project project) {
		return projectMapper.findProjectsList(project);
	}

	// 根据ID查询项目信息
	public Project projectByID(@Param("project") Project project) {
		if (project.getGroupId() > 0) {
			return projectMapper.projectById(project);
		} else {
			return projectMapper.projectNameById(project);
		}

	}

	// 根据项目ID与用户ID查询数据是否存在
	public GroupUserInfo GroupUserInfoByID(
			@Param("groupUserInfo") GroupUserInfo groupUserInfo) {
		return projectMapper.GroupUserInfoByID(groupUserInfo);
	}

	// 添加项目数据
	public int insertProject(@Param("project") Project project) {
		return projectMapper.insertProject(project);
	}

	// 添加中间表数据
	public int insertGroupUserInfo(
			@Param("groupUserInfo") GroupUserInfo groupUserInfo) {
		return projectMapper.insertGroupUserInfo(groupUserInfo);
	}

	// 修改项目数据
	public int updateProject(@Param("project") Project project) {
		return projectMapper.updateProject(project);
	}

	// 修改中间表数据
	public int updateGroupUserInfo(
			@Param("groupUserInfo") GroupUserInfo groupUserInfo) {
		return projectMapper.updateGroupUserInfo(groupUserInfo);
	}

	// 删除项目数据
	public int deleteProject(@Param("project") Project project) {
		return projectMapper.deleteProject(project);
	}

	// 删除中级表数据
	public int deleteGroupUserInfo(Long groupId) {
		return projectMapper.deleteGroupUserInfo(groupId);
	}
}
