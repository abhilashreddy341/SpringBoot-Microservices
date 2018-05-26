package com.egaints.mockservice;

import java.util.List;

import com.egiants.service.UserService;
import com.example.springBoot.Demo.User;

public class MockUserService implements UserService {
	

	@Override
	public List<User> getUsers() {
		return null;
	}

}
