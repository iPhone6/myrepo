package com.elead.organ.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elead.organ.model.BaseRequestResult;
import com.elead.organ.model.GroupUserInfo;
import com.elead.organ.model.Project;
import com.elead.organ.model.RequestResult;
import com.elead.organ.service.ProjectService;

@RestController
public class ProjectController extends BaseRequestResult {
	@Autowired
	ProjectService projectService;

	// 查询所有项目或根据项目里字段进行筛选数据
	@RequestMapping(value = "/findProjectList")
	public RequestResult findProjectList(
			@RequestParam(value = "name", required = true) String name) {
		Project project = new Project();
		project.setGroupName(name);
		List<Project> projectsList = projectService.findProjectsList(project);

		if (projectsList.size() > 0) {
			return resultInfo("1", "请求成功", projectsList);
		} else {
			return resultInfo("0", "请求失败！", "");
		}
	}

	// 根据ID查询数据
	@RequestMapping(value = "/projectById")
	public RequestResult projectById(
			@RequestParam(value = "groupId", required = true) Long groupId) {
		Project pr = new Project();
		pr.setGroupId(groupId);
		Project project = projectService.projectByID(pr);

		if (project == null || project.equals("")) {
			return resultInfo("0", "请求失败！", "");
		} else {
			return resultInfo("1", "请求成功", project);
		}
	}

	// 添加项目与中间表
	@RequestMapping(value = "/insertProject")
	public RequestResult insertProject(
			@RequestParam(value = "groupName", required = true) String groupName,
			@RequestParam(value = "remark", required = true) String remark,
			@RequestParam(value = "enabled", required = true) String enabled,
			@RequestParam(value = "userId", required = true) Long[] userId) {
		Project project = new Project();
		project.setGroupName(groupName);
		project.setEnabled(Long.parseLong(enabled));
		project.setRemark(remark);
		int i = projectService.insertProject(project); // 添加项目
		Project pr = new Project();
		pr.setGroupId(Long.parseLong("0"));
		pr.setGroupName(groupName);
		Project pro = projectService.projectByID(pr);
		int io = Integer.parseInt(String.valueOf(pro.getGroupId()));

		// 添加用户与项目的中间表数据
		for (Long a : userId) {
			GroupUserInfo groupUserInfo = new GroupUserInfo();
			groupUserInfo.setGroup_id(Long.parseLong(String.valueOf(io)));
			groupUserInfo.setUser_id(a);
			projectService.insertGroupUserInfo(groupUserInfo);
		}

		if (io > 0) {
			return resultInfo(String.valueOf(i), "添加成功",
					Long.parseLong(String.valueOf(io)));
		} else {
			return resultInfo(String.valueOf(i), "添加失败！成功", "");
		}
	}

	// 修改项目信息
	@RequestMapping(value = "/updateProject")
	public RequestResult updateProject(
			@RequestParam(value = "groupId", required = true) Long groupId,
			@RequestParam(value = "groupName", required = true) String groupName,
			@RequestParam(value = "userId", required = true) Long[] userId) {
		Project project = new Project();
		project.setGroupId(groupId);
		project.setGroupName(groupName);
		int io = projectService.updateProject(project);

		// 判断修改项目的用户是否存在，不存在就添加
		for (Long a : userId) {
			GroupUserInfo groupUserInfo = new GroupUserInfo();
			groupUserInfo.setGroup_id(Long.parseLong(String.valueOf(groupId)));
			groupUserInfo.setUser_id(a);
			GroupUserInfo groupU = projectService
					.GroupUserInfoByID(groupUserInfo);

			if (groupU == null || groupU.equals(null)) {
				projectService.insertGroupUserInfo(groupUserInfo);
			} else {
				// projectService.updateGroupUserInfo(groupUserInfo);
				System.out.println("已存在！");
			}
		}

		if (io > 0) {
			return resultInfo(String.valueOf(io), "修改成功", "");
		} else {
			return resultInfo(String.valueOf(io), "修改失败！", "");
		}
	}

	// 删除项目，0表示隐藏。1表示启用
	@RequestMapping(value = "/deleteProject")
	public RequestResult deleteProject(
			@RequestParam(value = "groupId", required = true) Long groupId) {
		Project project = new Project();
		project.setGroupId(groupId);
		project.setEnabled(Long.parseLong("0"));
		int io = projectService.deleteProject(project);

		if (io > 0) {
			return resultInfo(String.valueOf(io), "删除成功", "");
		} else {
			return resultInfo(String.valueOf(io), "删除失败！", "");
		}
		// projectService.deleteGroupUserInfo(groupId);
	}

}
