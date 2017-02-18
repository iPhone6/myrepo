package com.elead.organ.model;

import java.util.Date;

/**
 * 附件 实体类
 * 
 * @author Administrator
 *
 */
public class MsEnclosure {
	private Integer id;
	private String name;	// 名称
	private String description;	// 详细描述
	private String type_enclosure;	// 类型
	private String storage_number;	// 存储编号
	private String submitter;	// 提交人
	private Date commit_time;	// 提交时间
	private Integer size;	// 大小
	private String edition;	// 版本
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType_enclosure() {
		return type_enclosure;
	}
	public void setType_enclosure(String type_enclosure) {
		this.type_enclosure = type_enclosure;
	}
	public String getStorage_number() {
		return storage_number;
	}
	public void setStorage_number(String storage_number) {
		this.storage_number = storage_number;
	}
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public Date getCommit_time() {
		return commit_time;
	}
	public void setCommit_time(Date commit_time) {
		this.commit_time = commit_time;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	@Override
	public String toString() {
		return "MsEnclosure [id=" + id + ", name=" + name + ", description=" + description + ", type_enclosure=" + type_enclosure + ", storage_number=" + storage_number
				+ ", submitter=" + submitter + ", commit_time=" + commit_time + ", size=" + size + ", edition=" + edition + "]";
	}
	
}
