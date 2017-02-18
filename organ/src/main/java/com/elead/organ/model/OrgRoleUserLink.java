package com.elead.organ.model;
/**
 * @author  ex_wencz 
 * E-mail: chuanzhi.wen@partner.midea.com
 * @date 创建时间：2017年2月15日 上午9:34:34 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return
 */
public class OrgRoleUserLink
{
	private Long id ; //id
	private Long userid ; //关联用户id
	private Long relationid ; //组织角色中间表id
	private String remark ; //描述
	private boolean enabled = true; //是否有效 (true:有效，false：无效)
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getRelationid() {
		return relationid;
	}
	public void setRelationid(Long relationid) {
		this.relationid = relationid;
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
