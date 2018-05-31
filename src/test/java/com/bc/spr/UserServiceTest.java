package com.bc.spr;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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
import com.egiants.user.dao.UserDao;
import com.egiants.User;
import com.egiants.service.UserService;

public class UserServiceTest {
	
	private User user;
	private List<Object> users;
	
	
	UserDao userDao = mock(UserDao.class); 
	
	@InjectMocks
	UserService userService;
	
	@Before
	public void setUp() {
//		this.user = Mockito.mock(User.class);
//		this.users = Arrays.asList(user);
//		Mockito.doReturn("firstName")
//		.when(this.user)
//		.getFirstName();
		User user = new User("abhilash@gmail.com","abhilash","gaddam","heythere","1234567890");
	}

	@Test
	public void testGetUsers() throws Exception {
		List<User> ul = new ArrayList<User>();
		ul.add(user);
		Mockito.when(userDao.getUsers()).thenReturn(ul);
		assertEquals(ul,userService.getUsers());
		
		
	}

	@Test
	public void testGetUser() throws Exception {
		Mockito.doReturn(user)
		.when(userDao.getUser("abhilash@gmail.com"));
		assertEquals(user,userService.getUser("abhilash@gmail.com"));
	}

	@Test
	public void testDeleteUser() throws Exception {
		
		Mockito.when(userDao.deleteUser("abhilash@gmail.com")).thenReturn(true);
		assertTrue(userService.deleteUser("abhilash@gmail.com"));
		
	}

	@Test
	public void testUpdateUser() throws Exception {
		
		Mockito.when(userDao.updateUser(user)).thenReturn(user);
		assertEquals(user,userService.updateUser(user));
	}

	@Test
	public void testAddUser() throws Exception {
		
		Mockito.when(userDao.addUser(user)).thenReturn(user);
		assertEquals(user,userService.addUser(user));
	}

}
