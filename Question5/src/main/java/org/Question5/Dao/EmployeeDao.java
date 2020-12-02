package org.Question5.Dao;

import java.util.List;

import org.Question5.Model.Employee;


public interface EmployeeDao {
	
	public int create(Employee emp);

	public List<Employee> read();

	public List<Employee> findStudentById(int studentId);

	public int update(Employee emp);

	public int delete(int studentId);

}
