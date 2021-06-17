package com.account.statement.domain;

public class ValidationResponse{

	private String message;
	private int msgStausCode;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMsgStausCode() {
		return msgStausCode;
	}
	public void setMsgStausCode(int msgStausCode) {
		this.msgStausCode = msgStausCode;
	}

}
