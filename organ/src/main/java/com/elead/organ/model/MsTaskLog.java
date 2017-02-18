package com.elead.organ.model;

import java.util.Date;

/**
 * 任务日志 实体类
 * 
 * @author Administrator
 *
 */
public class MsTaskLog {
	private Integer id;
	private String action;	// 动作
	private Date operating_time;
	private String operator;	// 操作人
	private String module;	// 模块
	private String log_type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getOperating_time() {
		return operating_time;
	}
	public void setOperating_time(Date operating_time) {
		this.operating_time = operating_time;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	
	@Override
	public String toString() {
		return "MsTaskLog [id=" + id + ", action=" + action + ", operating_time=" + operating_time + ", operator=" + operator + ", module=" + module + ", log_type=" + log_type
				+ "]";
	}
	
}
