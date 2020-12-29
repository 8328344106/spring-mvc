package org.websparrow.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.websparrow.config.WebMvcConfig;
import org.websparrow.dao.StudentDao;
import org.websparrow.model.Employee;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
class ReadControllerTest {

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private StudentDao studentDao;

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		studentDao = mock(StudentDao.class);
//	MockitoAnnotations.initMocks(this);
	}

	@Test
	public void ReadTest() throws Exception {
		Employee user1 = new Employee(1,"niha","teja","niha",12000);
		Employee user2 = new Employee(2,"niha1","teja","niha",1000);
		Employee user3 = new Employee(3,"niha2","teja","niha",30000);
		List<Employee> studentList = new ArrayList<>();
		studentList.add(user1);
		studentList.add(user2);
		studentList.add(user3);
		when(studentDao.read()).thenReturn(studentList);
		mockMvc.perform(get("/read"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("listStudent"))
				.andExpect(view().name("read")).andReturn();
	}

}
