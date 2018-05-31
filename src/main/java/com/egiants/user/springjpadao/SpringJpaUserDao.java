package com.egiants.user.springjpadao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.User;
import com.egiants.user.dao.UserDao;

@Repository
public class SpringJpaUserDao implements UserDao{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() throws Exception {
		 if(userRepository.findAll().size()>0) {
				return userRepository.findAll();
			}
		 throw new Exception("No user Exists");
	}
	
	 public Optional<User> getUser(String email) throws Exception {
		 if(!userRepository.findById(email).isPresent()) {
				throw new Exception("No user Found with given Email");
			}
	    	return userRepository.findById(email);
	 }
	 
	 public boolean deleteUser(String email) throws Exception {
		 if(userRepository.existsById(email)) {
		 userRepository.deleteById(email);
			return true;
		 }
		 throw new Exception("Delete not performed");
	 }
	 
	 public User updateUser(User user) throws Exception {
		 if(userRepository.existsById(user.getEmailAddress())) {
			 return userRepository.save(user);
		 }
		 throw new Exception("No user Found");
			
	 }
	 
	 public User addUser(User user) throws Exception {
		 if(userRepository.existsById(user.getEmailAddress())) {
			 throw new Exception("User Already Exists");
		 }
		
		    return userRepository.save(user);
	 }
}
