package com.egiants.user.dao;

import java.util.List;
import java.util.Optional;

import com.egiants.User;



public interface UserDao {
	
	List<User> getUsers() throws Exception;
	
	Optional<User> getUser(String email) throws Exception;
	
	boolean deleteUser(String email) throws Exception;
	
	User updateUser(User user) throws Exception;
	
	User addUser(User user) throws Exception;

}
