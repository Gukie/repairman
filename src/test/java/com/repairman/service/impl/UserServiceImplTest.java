package com.repairman.service.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.repairman.base.ServiceResult;
import com.repairman.model.User;
import com.repairman.service.UserService;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-base.xml","classpath:spring/spring-datasource.xml"})
@Ignore
public class UserServiceImplTest extends TestCase{

	@Resource
	private UserService myUserService;

	@Test
	public void testRegister() {
		String username = "yes-90";
		String password = "today";
		String sex = "";
		String phone = "15155665845";
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setPhone(phone);

		ServiceResult serviceResult = myUserService.register(user);
		Assert.assertTrue(serviceResult.isSuccess());
	}

	@Test
	public void testLogin() {
		String username = "test";
		String password = "123";
		Integer expectedUserId = 1;
		ServiceResult serviceResult = myUserService.login(username, password);
		Assert.assertTrue(serviceResult.isSuccess());

		User user = (User) serviceResult.getData();
		Assert.assertEquals(expectedUserId, user.getId());
	}

}
