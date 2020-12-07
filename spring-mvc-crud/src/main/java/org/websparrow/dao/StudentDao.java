package org.websparrow.dao;

import java.util.List;

import org.websparrow.model.Employee;

public interface StudentDao {

	public int create(Employee student);

	public List<Employee> read();

	public List<Employee> findStudentById(int studentId);

	public int update(Employee student);

	public int delete(int studentId);

}
