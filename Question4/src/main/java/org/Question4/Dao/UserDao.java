package org.Question4.Dao;

import java.util.List;

import org.Question4.Model.User;




public interface UserDao {
	public int create(User user);

	public List<User> read();

	public List<User> findStudentById(int userId);
	
	public boolean userlogin(User user);
}
