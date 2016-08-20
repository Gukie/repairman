package com.repairman.service;

import com.repairman.base.ServiceResult;
import com.repairman.model.User;

public interface UserService {

	ServiceResult register(User user);
	ServiceResult login(String username, String password);
}

