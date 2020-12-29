package org.websparrow.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import org.websparrow.config.WebMvcConfig;
import org.websparrow.model.Employee;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
class StudentDaoTest {

	MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private StudentDao studentDao;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		studentDao = mock(StudentDao.class);
	}
	
	@Test
	public void CreateMethodTest() throws Exception
	{
		Employee user = new Employee();
		user.setEmployeeDepartment("niha");
		user.setEmployeeDesignation("niha");
		user.setEmployeeName("niha");
		user.setEmployeeSalary(12000);
		when(studentDao.create(user)).thenReturn(1);
		assertEquals(1, studentDao.create(user));
		assertNotNull(studentDao.create(user));
	}
	
	@Test
	public void ReadMethodTest() throws Exception
	{

		Employee user1 = new Employee(1,"niha","teja","niha",12000);
		Employee user2 = new Employee(2,"niha1","teja","niha",1000);
		Employee user3 = new Employee(3,"niha2","teja","niha",30000);
		List<Employee> studentList = new ArrayList<>();
		studentList.add(user1);
		studentList.add(user2);
		studentList.add(user3);
		when(studentDao.read()).thenReturn(studentList);
		assertEquals(studentList, studentDao.read());
		assertNotNull(studentDao.read());
	}
	
	@Test
	public void FindByIdTest() throws Exception
	{
		Employee user1 = new Employee(1,"niha","teja","niha",12000);
		List<Employee> studentList = new ArrayList<>();
		studentList.add(user1);
		when(studentDao.findStudentById(1)).thenReturn(studentList);
		assertEquals(studentList,studentDao.findStudentById(1) ); 
		assertNotNull(studentDao.findStudentById(1));
	}
	
	@Test
	public void UpdateMethodTest() throws Exception
	{
		Employee user = new Employee();
		user.setEmployeeId(1);
		user.setEmployeeDepartment("niha");
		user.setEmployeeDesignation("niha");
		user.setEmployeeName("niha");
		user.setEmployeeSalary(12000);
		when(studentDao.update(user)).thenReturn(1);
		assertEquals(1, studentDao.update(user));
		assertNotNull(studentDao.update(user));
	}
	
	@Test
	public void DeleteMethodTest() throws Exception
	{
		when(studentDao.delete(1)).thenReturn(1);
		assertEquals(1, studentDao.delete(1));
		assertNotNull(studentDao.delete(1));
	}

}
