package com.egiants.user.springjpadao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.egiants.User; 


public interface UserRepository  extends JpaRepository<User, String>{

}
