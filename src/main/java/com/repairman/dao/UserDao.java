package com.repairman.dao;

import org.apache.ibatis.annotations.Param;

import com.repairman.model.User;

public interface UserDao {

	User getUserByNameAndPwd(@Param("username") String username,@Param("password") String password);

	Integer createNewUser(User user);
}
