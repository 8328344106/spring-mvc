package org.Question4.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.Question4.Config.WebMvcConfig;
import org.Question4.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
class UserDaoTest 
{

	MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Mock
    JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserDao studentDao;
	
	@BeforeEach
	void setUp() throws Exception 
	{
//		assertNotNull(jdbcTemplate);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void CreateMethodTest() throws Exception
	{
		User user = new User();
		user.setEmail("niha");
		user.setPassword("niha");
		user.setUsername("niha");
		assertNotNull(studentDao.create(user));
	}
	
	@Test
	public void ReadMethodTest() throws Exception
	{
//		Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM assignment4 where user_id=?", List.class))
//      .thenReturn(studentList);
		User user1 = new User(1,"niha","teja","niha");
		User user2 = new User(2,"niha1","teja","niha");
		User user3 = new User(3,"niha2","teja","niha");
		List<User> studentList = new ArrayList<>();
		studentList.add(user1);
		studentList.add(user2);
		studentList.add(user3);
//		assertNotNull(studentDao.read());
	}

	@Test
	public void UserLoginTest() throws Exception
	{
//		Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM assignment4 where user_username=? AND user_password=?", boolean.class))
//		.thenReturn(false);
		User user1 = new User();
		user1.setUsername("gyerj");
		user1.setPassword("gfhh");
//		assertNotNull(studentDao.userlogin(user1));
	}

}
