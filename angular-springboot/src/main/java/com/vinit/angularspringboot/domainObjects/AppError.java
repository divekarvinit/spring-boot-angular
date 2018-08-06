package com.vinit.angularspringboot.domainObjects;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class AppError {

	public AppError() {
		// TODO Auto-generated constructor stub
	}

	private Date localErrorTime;
	private String message;
	private HttpStatus status;
	public Date getLocalErrorTime() {
		return localErrorTime;
	}
	public void setLocalErrorTime(Date localErrorTime) {
		this.localErrorTime = localErrorTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public AppError(Date localErrorTime, String message, HttpStatus status) {
		super();
		this.localErrorTime = localErrorTime;
		this.message = message;
		this.status = status;
	}
	@Override
	public String toString() {
		return "AppError [localErrorTime=" + localErrorTime + ", message=" + message + ", status=" + status + "]";
	}

	
}
