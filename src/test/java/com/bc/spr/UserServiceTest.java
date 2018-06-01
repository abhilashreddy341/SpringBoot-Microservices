package com.bc.spr;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.egiants.user.dao.UserDao;
import com.egiants.User;
import com.egiants.defaultservice.DefaultUserService;
import com.egiants.exceptions.ResourceNotFoundException;
import com.egiants.service.UserService;


public class UserServiceTest {
	
	private static final String EMAIL = "xyz@gmail.com";
	
	private User user;
	private List<User> users ;
	
	@Mock
	private UserDao userDao;
	 
	@InjectMocks
	private DefaultUserService userService;
	
	@Before
	public void setUp() throws Exception {
		
		this.user = Mockito.mock(User.class);
		Mockito.doReturn("abhilash").when(this.user).getFirstName();
		Mockito.doReturn("abhilash@gmail.com").when(this.user).getEmailAddress();
		//this.users = new ArrayList<>();
		MockitoAnnotations.initMocks(this);
		users = new ArrayList<User>();
		users.add(user);
	
	}

	@Test
	public void testGetUsers() throws Exception {
		
		Mockito.doReturn(users)
		.when(this.userDao)
		.getUsers();
		
	    List<User> actualUsers = userService.getUsers();
	    assertEquals(user.getEmailAddress(),actualUsers.get(0).getEmailAddress());
	    
	}
	
//	@Test
//	public void testGetUser() throws Exception {
//		
//		Mockito.doReturn(user)
//		.when(this.userDao)
//		.getUser(EMAIL);
//		
//	    User actualUser = userService.getUser(EMAIL);
//	    assertEquals("abc",actualUser.getFirstName());
//	    
//	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testGetUserNotFound() throws Exception {
		
		Mockito.doThrow(Exception.class)
		.when(this.userDao)
		.getUser(EMAIL);
		
	    this.userService.getUser(EMAIL);
	    
	}

	@Test
	public void testGetUser() throws Exception {
		
		Mockito.doReturn(user)
		 .when(userDao)
		 .addUser(Mockito.any(User.class));
		Mockito.when(userDao.deleteUser("abhilash@gmail.com")).thenReturn(true);
		assertEquals(user,userDao  .addUser(user));
	}

	@Test
	public void testDeleteUser() throws Exception {
		Mockito.doReturn(true)
		 .when(userDao)
		 .deleteUser(Mockito.anyString());
		Mockito.when(userDao.deleteUser("abhilash@gmail.com")).thenReturn(true);
		assertTrue(userService.deleteUser("abhilash@gmail.com"));
	}

	@Test
	public void testUpdateUser() throws Exception {
		Mockito.doReturn(user)
		 .when(userDao)
		 .updateUser(Mockito.any(User.class));	
		assertEquals(user,userService.updateUser(user));
	}

	@Test
	public void testAddUser() throws Exception {
		Mockito.doReturn(user)
		 .when(userDao)
		 .addUser(Mockito.any(User.class));
		assertEquals(user,userService.addUser(user));
	}

}
