package com.elead.organ.model;
/**
 * @author  ex_wencz 
 * E-mail: chuanzhi.wen@partner.midea.com
 * @date 创建时间：2017年2月15日 上午9:43:23 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return
 */
public class OrgRoleLink
{
	private Long relationid ;//id
	private Long orgid ; //组织Id
	private Long roleid ;// 角色id
	private String remark ;// 描述
	private boolean enabled = true; //是否有效 (true:有效，false：无效)
	public Long getRelationid() {
		return relationid;
	}
	public void setRelationid(Long relationid) {
		this.relationid = relationid;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
