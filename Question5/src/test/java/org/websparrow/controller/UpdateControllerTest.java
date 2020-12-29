package org.websparrow.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
class UpdateControllerTest {

MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Mock
	private StudentDao studentDao;
	
	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		studentDao = mock(StudentDao.class);
	}

	@Test
	public void FindByIdTest() throws Exception
	{
		Employee user1 = new Employee(1,"niha","teja","niha",12000);
		List<Employee> studentList = new ArrayList<>();
		studentList.add(user1);
		Mockito.when(studentDao.findStudentById(1)).thenReturn(studentList);
		mockMvc.perform(get("/update/{employeeId}",1))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("listStudent"))
				.andExpect(view().name("update")).andReturn();
	}
	
	@Test
	public void UpdateTest() throws Exception
	{
		Employee user = new Employee();
		user.setEmployeeId(1);
		user.setEmployeeDepartment("niha");
		user.setEmployeeDesignation("niha");
		user.setEmployeeName("niha");
		user.setEmployeeSalary(12000);
		when(studentDao.create(user)).thenReturn(1);
		mockMvc.perform(post("/update")
				.param("employeeId", "1")
				.param("employeeName", "niharika")
				.param("employeeDepartment", "niha@gmail.com")
				.param("employeeDesignation", "niha@1232")
				.param("employeeSalary", "12000"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("msg"))
				.andExpect(view().name("update")).andReturn();
	}

}
