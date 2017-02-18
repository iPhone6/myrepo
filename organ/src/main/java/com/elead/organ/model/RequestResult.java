package com.elead.organ.model;

public class RequestResult {

	private String code;
	private String message;
	private Object data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return data;
	}
	public void setObject(Object object) {
		this.data = object;
	}
}
