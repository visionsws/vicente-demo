package com.vicente.vicentedemo.common;

import java.io.Serializable;

/**
 * common return
 * @author xuxueli 2015-12-4 16:32:31
 * @param <T>
 */
public class ResultBean<T> implements Serializable {
	public static final long serialVersionUID = 42L;
	public static final int SUCCESS_CODE = 200;
	public static final int FAIL_CODE = 500;

	public static final ResultBean<String> SUCCESS = new ResultBean<String>(null);
	public static final ResultBean<String> FAIL = new ResultBean<String>(FAIL_CODE, "fail");

	private int code;
	private String msg = "success";
	private T content;

	public ResultBean(){}
	public ResultBean(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ResultBean(T content) {
		this.code = SUCCESS_CODE;
		this.content = content;
	}
	
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
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResultBean [code=" + code + ", msg=" + msg + ", content=" + content + "]";
	}

}
