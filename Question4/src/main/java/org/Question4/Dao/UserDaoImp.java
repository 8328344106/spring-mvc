package org.Question4.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.Question4.Model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImp implements UserDao
{
	private JdbcTemplate jdbcTemplate;

	public UserDaoImp(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	public int create(User student) {

		String sql = "insert into assignment4(user_username,user_email,user_password) values(?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { student.getUsername(),student.getPassword(), student.getEmail()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	public List<User> read() {
		List<User> studentList = jdbcTemplate.query("SELECT * FROM assignment4", new RowMapper<User>() {

			
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User student = new User();

				student.setId(rs.getInt("user_id"));
				student.setUsername(rs.getString("user_name"));
				student.setEmail(rs.getString("user_email"));
				student.setPassword(rs.getString("user_password"));

				return student;
			}

		});

		return studentList;
	}

	
	public List<User> findStudentById(int studentId) {

		List<User> studentList = jdbcTemplate.query("SELECT * FROM assignment4 where user_id=?",
				new Object[] { studentId }, new RowMapper<User>() {

					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User student = new User();
						
						student.setId(rs.getInt("user_id"));
						student.setUsername(rs.getString("user_name"));
						student.setEmail(rs.getString("user_email"));
						student.setPassword(rs.getString("user_password"));

						return student;
					}

				});

		return studentList;
	}


	public boolean userlogin(User user)
	{
		List<User> studentList = jdbcTemplate.query("SELECT * FROM assignment4 where user_username=? AND user_password=?",
				new Object[] { user.getUsername(),user.getPassword() }, new RowMapper<User>() {

					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User student = new User();

						student.setId(rs.getInt("user_id"));
						student.setUsername(rs.getString("user_name"));
						student.setEmail(rs.getString("user_email"));
						student.setPassword(rs.getString("user_password"));

						return student;
					}

				});
		if(studentList != null)
		{
			return true;
		}

		return false;
	}

}
