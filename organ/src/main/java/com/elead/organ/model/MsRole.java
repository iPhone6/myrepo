package com.elead.organ.model;

/**
 * 角色实体类
 * 
 * @author Administrator
 *
 */
public class MsRole {
	private Integer roleId;
	private String roleName;
	private String remark;
	private Boolean enabled;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "MsRole [roleId=" + roleId + ", roleName=" + roleName + ", remark=" + remark + ", enabled=" + enabled  + "]";
	}
	
}
