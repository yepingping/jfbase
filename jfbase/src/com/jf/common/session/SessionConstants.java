package com.jf.common.session;

public enum SessionConstants {
	
	COMPANY("COMPANY"),
	
	COMPANY_ID("COMPANY_ID"),
	
	DEPT("DEPT"),
	
	DEPT_ID("DEPT_ID"),
	
	USER("USER"),
	
	USER_ID("USER_ID")
	;
	
	
	private String value;
	
	private SessionConstants(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
