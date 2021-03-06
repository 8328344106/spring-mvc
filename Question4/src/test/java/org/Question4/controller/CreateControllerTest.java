package org.Question4.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.Question4.Config.WebMvcConfig;
import org.Question4.Dao.UserDao;
import org.Question4.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class CreateControllerTest {

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
	}
	
	@Test
	public void CreateStudentTest() throws Exception
	{
		User user = new User();
		user.setEmail("niha");
		user.setPassword("niha");
		user.setUsername("niha");
		when(studentDao.create(user)).thenReturn(1);
		mockMvc.perform(post("/create")
				.param("username", "niharika")
				.param("email", "niha@gmail.com")
				.param("password", "niha@1232"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("msg"))
				.andExpect(view().name("login")).andReturn();
	}
	
	

}
