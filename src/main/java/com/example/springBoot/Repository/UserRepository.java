package com.example.springBoot.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBoot.Demo.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
