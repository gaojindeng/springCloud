
package com.gjd.news.common;

@Deprecated
public class RestResponse<T>{
	private int code;
	private String msg;
	private T data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public static <T> RestResponse<T> success(){
		return new RestResponse<T>();
	}

	public static <T>RestResponse<T> success(T t){
		RestResponse<T> data = new RestResponse<>();
		data.setData(t);
		return data;
	}
	
	public static <T> RestResponse<T> error(RestCode code){
		return new RestResponse<T>(code.code,code.msg);
	}
	
	public RestResponse(){
		this(RestCode.OK.code,RestCode.OK.msg);
	}
	public RestResponse(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
}