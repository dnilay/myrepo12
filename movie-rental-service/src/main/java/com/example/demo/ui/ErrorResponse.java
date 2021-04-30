package com.example.demo.ui;

public class ErrorResponse {
	
	private String message;
	private Integer statusCode;
	private Long errorLogTime;
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(String message, Integer statusCode, Long errorLogTime) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.errorLogTime = errorLogTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Long getErrorLogTime() {
		return errorLogTime;
	}
	public void setErrorLogTime(Long errorLogTime) {
		this.errorLogTime = errorLogTime;
	}

}
