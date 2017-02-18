package com.elead.organ.model;

/**
 * 用户实体
 */
public class User {
	private Long id;
	private String name;
	private String orderInDepts;
	private String position;
	private String mobile;
	private String tel;
	private String workPlace;
	private String remark;
	private String email;
	private String jobnumber;
	private Boolean isHide;
	private Boolean isSenior;
	private String extattr;
	private boolean enabled;
	private String organizationName;//组织(部门)名称
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderInDepts() {
		return orderInDepts;
	}
	public void setOrderInDepts(String orderInDepts) {
		this.orderInDepts = orderInDepts;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobnumber() {
		return jobnumber;
	}
	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}
	public Boolean getIsHide() {
		return isHide;
	}
	public void setIsHide(Boolean isHide) {
		this.isHide = isHide;
	}
	public Boolean getIsSenior() {
		return isSenior;
	}
	public void setIsSenior(Boolean isSenior) {
		this.isSenior = isSenior;
	}
	public String getExtattr() {
		return extattr;
	}
	public void setExtattr(String extattr) {
		this.extattr = extattr;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", orderInDepts="
				+ orderInDepts + ", position=" + position + ", mobile="
				+ mobile + ", tel=" + tel + ", workPlace=" + workPlace
				+ ", remark=" + remark + ", email=" + email + ", jobnumber="
				+ jobnumber + ", isHide=" + isHide + ", isSenior=" + isSenior
				+ ", extattr=" + extattr + ", enabled=" + enabled
				+ ", organizationName=" + organizationName + "]";
	}
}
