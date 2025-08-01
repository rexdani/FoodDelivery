package com.food.dao;

import java.sql.SQLException;
import java.util.*;
import com.food.models.*;



public interface UserDao {
	List<User> getAllUser();
	void addUser(User user) throws SQLException;
	void updateUser(User user);
	void deleteUser(String id);
	public User getUser(String id);
}
