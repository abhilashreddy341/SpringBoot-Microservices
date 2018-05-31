package com.bc.spr;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.egiants.User;
import com.egiants.controller.UserController;
import com.egiants.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetTesting {
	
	private MockMvc mockMvc;
	
	UserService userService = mock(UserService.class);
	
	@InjectMocks
	private UserController userController;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(userController)
				.build();
	}
	
	@Test
	public void testGetTest() throws Exception{
		
		when(userService.getUsers()).thenReturn(null);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/users")
				)
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.content().string(""));
	}
	
	@Test
	public void testGetTest1() throws Exception{
		
		User user = new User("abhi@gmail.com","abhilash","gaddam","heythere","1234567890");
		List<User> ul = new ArrayList<User>();
		ul.add(user);
		when(userService.getUsers()).thenReturn(ul);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/users")
				)
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[0].emailAddress", Matchers.is(user.getEmailAddress())))
		        .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", Matchers.is(user.getFirstName())))
		        .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName", Matchers.is(user.getLastName())))
		        .andExpect(MockMvcResultMatchers.jsonPath("$[0].password", Matchers.is(user.getPassword())))
		        .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", Matchers.is(user.getPhoneNumber())));
	}
	
	@Test
	public void testServiceGet() throws Exception {
		
		User user = new User("abhi@gmail.com","abhilash","gaddam","heythere","1234567890");
		
	}

}
