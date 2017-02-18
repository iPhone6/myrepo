package com.elead.organ.model;

import java.util.Date;

/**
 * 应用 实体类
 * 
 * @author Administrator
 *
 */
public class MsApplication {
	private Integer id;
	private String type;	// 类型
	private String identification;	// 应用标识
	private String appkey;	// appKey
	private String secret_key;	// 应用秘钥
	private Integer downloads;	// 下载量
	private Date create_time;	// 创建时间
	private Date update_time;	// 修改时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getSecret_key() {
		return secret_key;
	}
	public void setSecret_key(String secret_key) {
		this.secret_key = secret_key;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	@Override
	public String toString() {
		return "MsApplication [id=" + id + ", type=" + type + ", identification=" + identification + ", appkey=" + appkey + ", secret_key=" + secret_key + ", downloads="
				+ downloads + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
}
