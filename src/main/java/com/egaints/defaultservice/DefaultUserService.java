package com.egaints.defaultservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.egiants.service.UserService;
import com.egiants.user.dao.UserDao;
import com.example.springBoot.Demo.User;

public class DefaultUserService implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

}
