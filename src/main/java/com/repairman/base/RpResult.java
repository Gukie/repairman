package com.repairman.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

public class RpResult {
	public static final int FAILED = 0;// 失败
	public static final int SUCCESS = 1;// 成功
	public static final int UNKNOW = 2;// 未知
	private int resultCode;
	private String msg;
	private Object content;

	public RpResult() {
	}
	public RpResult(int resultCode) {
		this.resultCode = resultCode;
	}

	public RpResult(int resultCode, String msg, Object content) {
		this.resultCode = resultCode;
		this.msg = msg;
		this.content = content;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String toJson() {
		ValueFilter filter = new ValueFilter() {
			@Override
			public Object process(Object obj, String s, Object v) {
				if (v == null) {
					return "";
				}
				return v;
			}
		};
		return JSON.toJSONString(this, filter, SerializerFeature.DisableCircularReferenceDetect);
	}

	public RpResult failed() {
		this.resultCode = FAILED;
		this.msg = "失败";
		return this;
	}

	public RpResult failed(String msg) {
		this.resultCode = FAILED;
		this.msg = msg;
		return this;
	}

	public void pageTurn(String url) {
		this.msg = url;
	}

	public void authError() {
		this.msg = "验证失败";
	}

	public RpResult success() {
		this.resultCode = SUCCESS;
		this.msg = "成功";
		return this;
	}

	public void success(Object content) {
		this.resultCode = SUCCESS;
		this.msg = "成功";
		this.content = content;
	}

	public void success(String msg) {
		this.resultCode = SUCCESS;
		this.msg = msg;
	}

	public void success(String msg, Object content) {
		this.resultCode = SUCCESS;
		this.msg = msg;
		this.content = content;
	}


}
