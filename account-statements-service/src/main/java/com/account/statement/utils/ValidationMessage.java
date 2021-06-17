package com.account.statement.utils;

public enum ValidationMessage {
	
	AMT_EROR("Invalid amount"),
	ACCOUNT_ERROR("Invalid accountnumber"),
	DATE_FORMAT_ERROR("Invalid Date");
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	ValidationMessage(String msg){
	this.msg=msg;	
	}
}
