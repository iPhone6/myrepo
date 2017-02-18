package com.elead.organ.model;

/**
 * 组织（部门）实体
 */
public class Organization {
	private int id;
	private String name;//部门名称,长度限制为1~64个字符
	private String parentid;//父部门id。根部门id为1,默认为1
	private String sort;//在父部门中的次序值。sort值小的排序靠前
	private boolean createDeptGroup;//是否创建一个关联此部门的企业群，默认为false
	private boolean deptHiding;//是否隐藏部门, true表示隐藏, false表示显示
	private String deptPerimits;//可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用 | 符号进行分割
	private String userPerimits;//可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串，使用| 符号进行分割
	private boolean outerDept;//是否本部门的员工仅可见员工自己, 为true时，本部门员工默认只能看到员工自己
	private String outerPermitDepts;//本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用|符号进行分割
	private String outerPermitUsers;//本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用|符号进行分割
	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public boolean isCreateDeptGroup() {
		return createDeptGroup;
	}

	public void setCreateDeptGroup(boolean createDeptGroup) {
		this.createDeptGroup = createDeptGroup;
	}

	public boolean isDeptHiding() {
		return deptHiding;
	}

	public void setDeptHiding(boolean deptHiding) {
		this.deptHiding = deptHiding;
	}

	public String getDeptPerimits() {
		return deptPerimits;
	}

	public void setDeptPerimits(String deptPerimits) {
		this.deptPerimits = deptPerimits;
	}

	public String getUserPerimits() {
		return userPerimits;
	}

	public void setUserPerimits(String userPerimits) {
		this.userPerimits = userPerimits;
	}

	public boolean isOuterDept() {
		return outerDept;
	}

	public void setOuterDept(boolean outerDept) {
		this.outerDept = outerDept;
	}

	public String getOuterPermitDepts() {
		return outerPermitDepts;
	}

	public void setOuterPermitDepts(String outerPermitDepts) {
		this.outerPermitDepts = outerPermitDepts;
	}

	public String getOuterPermitUsers() {
		return outerPermitUsers;
	}

	public void setOuterPermitUsers(String outerPermitUsers) {
		this.outerPermitUsers = outerPermitUsers;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", sort=" + sort + ", createDeptGroup="
				+ createDeptGroup + ", deptHiding=" + deptHiding
				+ ", deptPerimits=" + deptPerimits + ", userPerimits="
				+ userPerimits + ", outerDept=" + outerDept
				+ ", outerPermitDepts=" + outerPermitDepts
				+ ", outerPermitUsers=" + outerPermitUsers + ", enabled="
				+ enabled + "]";
	}

}
