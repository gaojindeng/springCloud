package com.gjd.api.common;

public enum RestCode {
	OK(0,"ok"),
	UNKNOWN_ERROR(1,"未知异常");
	
	public final int code;
	public final String msg;
	
	private RestCode(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
