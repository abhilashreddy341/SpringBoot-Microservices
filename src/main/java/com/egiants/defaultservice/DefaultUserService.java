package com.egiants.defaultservice;

import java.util.List;
import java.util.Optional;
import com.egiants.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.service.UserService;
import com.egiants.user.dao.UserDao;

@Service
public class DefaultUserService implements UserService {
	
	@Autowired
	private UserDao userDao;

	public List<User> getUsers() throws Exception{
		  return userDao.getUsers();
	 }
	 
	 public Optional<User> getUser(String email) throws Exception {
		 return userDao.getUser(email);
	 }
	 
	 public boolean deleteUser(String email) throws Exception {
		 return userDao.deleteUser(email);
	 }
	 
	 public User updateUser(User user) throws Exception {
		 return userDao.updateUser(user);
			
	 }
	 
	 public User addUser(User user) throws Exception {
		 return userDao.addUser(user);
	 }

}
