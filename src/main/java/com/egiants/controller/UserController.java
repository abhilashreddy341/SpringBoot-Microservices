package com.egiants.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egiants.service.UserService;
import com.egiants.User;


@RestController
public class UserController {
	

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() throws Exception{
		return userService.getUsers();
	}

    @GetMapping("/user/{email}")
    public User getUser(@PathVariable String email) throws Exception {
		return userService.getUser(email);
	}

	@DeleteMapping("/user/{email}")
	public boolean deleteUser(@PathVariable String email) throws Exception {
        return userService.deleteUser(email);		
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) throws Exception {
		return userService.addUser(user);
	}

	@PutMapping("/user/{id}") 
	public User upduser(@RequestBody User user,@PathVariable String id) throws Exception {
		return userService.updateUser(user);
		}

}
