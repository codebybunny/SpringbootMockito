package com.learning.sprinbootmockito.api.model;

public class ResponseModel {
	
	public ResponseModel() {
		super();
	}
	public ResponseModel(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	private String message;
	private boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
