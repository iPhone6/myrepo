package com.elead.organ.model;

import java.util.Date;

/**
 * 风险实体
 */
public class Risk {
	private int id;
	private String name;
	private String description;
	private String type_risk;
	private Date planned_completion_time;
	private String priority;
	private String response_measures;
	private String present_people;
	private String person_liable;
	private Date actual_completion_time;
	private String status;
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
	public String getType_risk() {
		return type_risk;
	}
	public void setType_risk(String type_risk) {
		this.type_risk = type_risk;
	}
	public Date getPlanned_completion_time() {
		return planned_completion_time;
	}
	public void setPlanned_completion_time(Date planned_completion_time) {
		this.planned_completion_time = planned_completion_time;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getResponse_measures() {
		return response_measures;
	}
	public void setResponse_measures(String response_measures) {
		this.response_measures = response_measures;
	}
	public String getPresent_people() {
		return present_people;
	}
	public void setPresent_people(String present_people) {
		this.present_people = present_people;
	}
	public String getPerson_liable() {
		return person_liable;
	}
	public void setPerson_liable(String person_liable) {
		this.person_liable = person_liable;
	}
	public Date getActual_completion_time() {
		return actual_completion_time;
	}
	public void setActual_completion_time(Date actual_completion_time) {
		this.actual_completion_time = actual_completion_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Risk [name=" + name + ", description=" + description
				+ ", type_risk=" + type_risk + ", planned_completion_time="
				+ planned_completion_time + ", priority=" + priority
				+ ", response_measures=" + response_measures
				+ ", present_people=" + present_people + ", person_liable="
				+ person_liable + ", actual_completion_time="
				+ actual_completion_time + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
