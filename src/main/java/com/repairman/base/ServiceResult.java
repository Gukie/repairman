package com.repairman.base;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

public class ServiceResult {

	private boolean success;
	private String msg;
	private Integer resultCode ;
	public static final Integer CODE_ZERO =0;   //数据库异常
	public static final Integer CODE_ONE =1;    //成功
	public static final Integer CODE_TWO =2;    //失败

	private Map<String, Object> resultMap =  new HashMap<String, Object>();
	private Object data;

	public ServiceResult(boolean isSuccess,Object data){
		this.success = isSuccess;
		this.data = data;
	}

	public ServiceResult(boolean isSuccess,String msg){
		this.success = isSuccess;
		this.msg = msg;
	}


	/**
	 * 失败
	 */
	public ServiceResult failed() {
		this.success = false;
		return this;
	}

	/**
	 * 失败
	 *
	 * @param msg
	 */
	public ServiceResult failed(String msg) {
		this.success = false;
		this.msg = msg;
		return this;
	}

	/**
	 * 成功
	 */
	public ServiceResult success() {
		this.success = true;
		this.resultCode=1;
		return this;
	}

	/**
	 * 成功
	 * @param msg
	 */
	public ServiceResult success(String msg) {
		this.success = true;
		this.msg = msg;
		this.resultCode=1;
		return this;
	}

	/**
	 * 成功
	 * @param resultMap
	 */
	public ServiceResult success(Object data) {
		this.success = true;
		this.data=data;
		this.resultCode=1;
		return this;
	}

	/**
	 * 成功
	 * @param msg
	 * @param resultMap
	 */
	public ServiceResult success(String msg, Map<String, Object> resultMap) {
		this.success = true;
		this.msg = msg;
		this.resultMap = resultMap;

		return this;
	}

	public ServiceResult() {
		this.success = false;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		ValueFilter filter = new ValueFilter() {
			@Override
			public Object process(Object obj, String s, Object v) {
				if (v == null) {
					return "";
				}
				return v;
			}
		};
		return JSON.toJSONString(this,filter);
	}
}
