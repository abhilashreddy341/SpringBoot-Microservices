package com.example.springBoot.Demo;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.Repository.UserRepository;

@RestController
public class UserController {
	
	//exceptions, java x validation, swagger, Test cases missing 
	@Autowired
	private UserRepository userRepository;//we need lose coupling 

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

    @GetMapping("/user/{email}")
    public Optional<User> getUser(@PathVariable String email) {
		return userRepository.findById(email);
	}

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable String id) {
		userRepository.deleteById(id);
		return true;
	}

	@PostMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);	
	}

	@PutMapping("/user/{id}") 
	public User upduser(@RequestBody User user,@PathVariable String id) {
		return userRepository.save(user);
	}

}
