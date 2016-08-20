package com.repairman.base;

import com.alibaba.fastjson.JSONObject;
import com.repairman.model.User;

public abstract class BaseController{

	protected static User EMPTY_USER = new User();

	public static RpResult success() {
		return new RpResult(RpResult.SUCCESS, null, null);
	}

	public static RpResult success(Object data) {
		return new RpResult(RpResult.SUCCESS, null, data);
	}

	public static RpResult fail() {
		return new RpResult(RpResult.FAILED, null, null);
	}

	public static RpResult fail(String msg) {
		return new RpResult(RpResult.FAILED, msg, null);
	}

	public String stringToJson(RpResult jsonTfResult) {
		return stringToJsonCommon(jsonTfResult);
	}

	public String stringToJsonCommon(Object object){
		return JSONObject.toJSONString(object);
	}

}
