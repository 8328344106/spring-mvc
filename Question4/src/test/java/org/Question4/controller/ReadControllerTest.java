package org.Question4.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.Question4.Config.WebMvcConfig;
import org.Question4.Dao.UserDao;
import org.Question4.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
class ReadControllerTest {
	
	MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private UserDao studentDao;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		studentDao = mock(UserDao.class);
//		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void UserLoginTest() throws Exception
	{
		User user1 = new User(1,"niha","teja","niha");
		User user2 = new User(2,"niha1","teja","niha");
		User user3 = new User(3,"niha2","teja","niha");
		List<User> studentList = new ArrayList<>();
		studentList.add(user1);
		studentList.add(user2);
		studentList.add(user3);
		Mockito.when(studentDao.read()).thenReturn(studentList);
		mockMvc.perform(get("/read"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("listStudent"))
				.andExpect(view().name("read")).andReturn();
	}


}
