package org.websparrow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.websparrow.model.Employee;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public int create(Employee student) {

		String sql = "insert into student1(emp_employeeName,emp_employeeDepartment,emp_employeeDesignation,emp_employeeSalary) values(?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getEmployeeName(), student.getEmployeeDepartment(), student.getEmployeeDesignation(),student.getEmployeeSalary() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Employee> read() {
		List<Employee> studentList = jdbcTemplate.query("SELECT * FROM STUDENT1", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee student = new Employee();

				student.setEmployeeId(rs.getInt("emp_employeeId"));
				student.setEmployeeName(rs.getString("emp_employeeName"));
				student.setEmployeeDepartment(rs.getString("emp_employeeDepartment"));
				student.setEmployeeDesignation(rs.getString("emp_employeeDesignation"));
				student.setEmployeeSalary(rs.getInt("emp_employeeSalary"));

				return student;
			}

		});

		return studentList;
	}

	@Override
	public List<Employee> findStudentById(int studentId) {

		List<Employee> studentList = jdbcTemplate.query("SELECT * FROM STUDENT1 where emp_employeeId=?",
				new Object[] { studentId }, new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee student = new Employee();

						student.setEmployeeId(rs.getInt("emp_employeeId"));
						student.setEmployeeName(rs.getString("emp_employeeName"));
						student.setEmployeeDepartment(rs.getString("emp_employeeDepartment"));
						student.setEmployeeDesignation(rs.getString("emp_employeeDesignation"));
						student.setEmployeeSalary(rs.getInt("emp_employeeSalary"));

						return student;
					}

				});

		return studentList;
	}

	@Override
	public int update(Employee student) {
		
		String sql = "update  student1 set emp_employeeName=?, emp_employeeDepartment=?, emp_employeeDesignation=?,emp_employeeSalary=? where emp_employeeId=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getEmployeeName(), student.getEmployeeDepartment(), student.getEmployeeDesignation(),student.getEmployeeSalary(), student.getEmployeeId() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int studentId) {
		String sql = "delete from student1 where emp_employeeId=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { studentId });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
