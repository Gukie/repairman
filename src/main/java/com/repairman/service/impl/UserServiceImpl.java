package com.repairman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repairman.base.ServiceResult;
import com.repairman.dao.UserDao;
import com.repairman.model.User;
import com.repairman.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao myUserDao;

	@Override
	public ServiceResult register(User user) {
		ServiceResult serviceResult = new ServiceResult();
		Integer affectedRow = myUserDao.createNewUser(user);
		if(affectedRow>=1){
			serviceResult.success(user);
		}

		return serviceResult;
	}

	@Override
	public ServiceResult login(String username, String password) {
		ServiceResult serviceResult = new ServiceResult();
		User user = myUserDao.getUserByNameAndPwd(username, password);
		serviceResult.success(user);
		return serviceResult;
	}

}
