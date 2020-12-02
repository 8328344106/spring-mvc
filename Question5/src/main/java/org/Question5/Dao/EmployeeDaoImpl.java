package org.Question5.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.Question5.Model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	
	public int create(Employee student) {

		String sql = "insert into employee(emp_employeeName,emp_employeeDepartment,emp_employeeDesignation,emp_employeeSalary) values(?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getEmployeeName(), student.getEmployeeDepartment(), student.getEmployeeDesignation(),student.getEmployeeSalary() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	public List<Employee> read() {
		List<Employee> studentList = jdbcTemplate.query("SELECT * FROM employee", new RowMapper<Employee>() {

			
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee student = new Employee();

				student.setEmployeeId(rs.getInt("emp_employeeId"));
				student.setEmployeeName(rs.getString("emp_employeeName"));
				student.setEmployeeDepartment(rs.getString("emp_employeeDepartment"));
				student.setEmployeeDesignation(rs.getString("emp_employeeDesignation"));
				student.setEmployeeSalary(rs.getDouble("emp_employeeSalary"));

				return student;
			}

		});

		return studentList;
	}


	public List<Employee> findStudentById(int studentId) {

		List<Employee> studentList = jdbcTemplate.query("SELECT * FROM employee where emp_employeeId=?",
				new Object[] { studentId }, new RowMapper<Employee>() {

					
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee student = new Employee();

						student.setEmployeeId(rs.getInt("emp_employeeId"));
						student.setEmployeeName(rs.getString("emp_employeeName"));
						student.setEmployeeDepartment(rs.getString("emp_employeeDepartment"));
						student.setEmployeeDesignation(rs.getString("emp_employeeDesignation"));
						student.setEmployeeSalary(rs.getDouble("emp_employeeSalary"));

						return student;
					}

				});

		return studentList;
	}

	
	public int update(Employee student) {
		String sql = "update  employee set emp_employeeName=?, emp_employeeDepartment=?, emp_employeeDesignation=?, emp_employeeSalary=? where emp_employeeId=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getEmployeeName(), student.getEmployeeDepartment(), student.getEmployeeDesignation(),student.getEmployeeSalary(), student.getEmployeeId() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	public int delete(int studentId) {
		String sql = "delete from employee where emp_employeeId=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { studentId });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
