package com.repairman.model;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

public class User {

	private Integer id;

	private String username;

	private String password;

	private String sex;

	private String phone;

	private String role;// '求助者','维修师傅'

	private Date gmtCreated;

	private Date gmtModified;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return StringUtils.isEmpty(sex) ? "女" : sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
