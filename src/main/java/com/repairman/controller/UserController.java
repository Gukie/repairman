package com.repairman.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.repairman.base.BaseController;
import com.repairman.base.ServiceResult;
import com.repairman.model.User;
import com.repairman.service.UserService;

@Controller
@RequestMapping(value = "/user", produces = { "text/html;charset=UTF-8" })
public class UserController extends BaseController {

	@Resource
	private UserService myUserService;

	// @RequestMapping(value="/register")
	// public ResponseEntity<User> register(@RequestBody User user) {
	// ServiceResult serviceResult = myUserService.register(user);
	// if(serviceResult.isSuccess()){
	// return new ResponseEntity<User>((User)
	// serviceResult.getData(),HttpStatus.OK);
	// }
	// return new ResponseEntity<User>(EMPTY_USER,HttpStatus.BAD_REQUEST);
	// }

	//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	//	@ResponseBody
	//	public String register(@PathVariable("username") String username,
	//			@PathVariable("password") String password,
	//			@PathVariable("phone") String phone, @PathVariable("sex") String sex) {
	//		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password) &&
	//				StringUtils.isEmpty(phone)
	//				&& StringUtils.isEmpty(sex)) {
	//			return fail("parameters are invalid").toJson();
	//		}
	//
	//		User user = new User();
	//		user.setUsername(username);
	//		user.setPassword(password);
	//		user.setPhone(phone);
	//		user.setSex(sex);
	//
	//		ServiceResult serviceResult = myUserService.register(user);
	//		if (serviceResult.isSuccess()) {
	//			return success(serviceResult.getData()).toJson();
	//		}
	//		return fail("register failed").toJson();
	//	}

	//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	//	@ResponseBody
	//	public String register(String username, String password, String phone, String sex) {
	//		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password) && StringUtils.isEmpty(phone)
	//				&& StringUtils.isEmpty(sex)) {
	//			return fail("parameters are invalid").toJson();
	//		}
	//
	//		User user = new User();
	//		user.setUsername(username);
	//		user.setPassword(password);
	//		user.setPhone(phone);
	//		user.setSex(sex);
	//
	//		ServiceResult serviceResult = myUserService.register(user);
	//		if (serviceResult.isSuccess()) {
	//			return success(serviceResult.getData()).toJson();
	//		}
	//		return fail("register failed").toJson();
	//	}

	//	@RequestMapping(value = "/register", method = RequestMethod.POST,produces="application/json")
	//	@ResponseBody
	//	public String register(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("phone")String phone, @RequestParam("sex")String sex) {
	//		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password) && StringUtils.isEmpty(phone)
	//				&& StringUtils.isEmpty(sex)) {
	//			return fail("parameters are invalid").toJson();
	//		}
	//
	//		User user = new User();
	//		user.setUsername(username);
	//		user.setPassword(password);
	//		user.setPhone(phone);
	//		user.setSex(sex);
	//
	//		ServiceResult serviceResult = myUserService.register(user);
	//		if (serviceResult.isSuccess()) {
	//			return success(serviceResult.getData()).toJson();
	//		}
	//		return fail("register failed").toJson();
	//	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	@ResponseBody
//	public String register(String username, String password, String phone, String sex) {
//		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password) && StringUtils.isEmpty(phone)
//				&& StringUtils.isEmpty(sex)) {
//			return fail("parameters are invalid").toJson();
//		}
//
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setPhone(phone);
//		user.setSex(sex);
//
//		ServiceResult serviceResult = myUserService.register(user);
//		if (serviceResult.isSuccess()) {
//			return success(serviceResult.getData()).toJson();
//		}
//		return fail("register failed").toJson();
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public String register(String username, String password, String phone, String sex) {
		if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password) && StringUtils.isEmpty(phone)
				&& StringUtils.isEmpty(sex)) {
			return fail("parameters are invalid").toJson();
		}

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);

		ServiceResult serviceResult = myUserService.register(user);
		if (serviceResult.isSuccess()) {
			return success(serviceResult.getData()).toJson();
		}
		return fail("register failed").toJson();
	}

	@RequestMapping(value = "/login")
	public String login(String username, String password) {
		ServiceResult serviceResult = myUserService.login(username, password);
		if (serviceResult.isSuccess()) {
			return success(serviceResult.getData()).toJson();
		}
		return fail().toJson();
	}
}
