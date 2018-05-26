package com.egiants.user.springjpadao;

import org.springframework.beans.factory.annotation.Autowired;

import com.egiants.user.dao.UserDao;
import com.example.springBoot.Repository.UserRepository;

public class SpringJpaUserDao implements UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
