package com.food.daoimp;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.UserDao;
import com.food.models.User;
import com.food.util.db;

public class UserImp  implements UserDao{

	@Override
	public List<User> getAllUser() {
		Connection connection =db.getCon();
		ArrayList<User> li=new ArrayList<User>();
		User user=null;
		try {
			PreparedStatement prepare=connection.prepareStatement("Select * FROM User");
			ResultSet res=prepare.executeQuery();

			while(res.next()) {

				int userId=res.getInt(1);
				String name=res.getString(2);
				String userName=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phoneNumber=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createDate=res.getTimestamp(9);
				Timestamp lastLogin=res.getTimestamp(10);
				byte[] profile=res.getBytes(11);
				user=new User(userId, name, userName, password, email, phoneNumber, address, role, createDate, lastLogin,profile);
				li.add(user);
			}





		} catch (SQLException e) {

			e.printStackTrace();
		}
		return li;

	}

	@Override
	public void addUser(User user) throws SQLException{
		Connection connection =db.getCon();


		
			PreparedStatement prepare=connection.prepareStatement("insert into User(name,userName,password,email,phoneNumber,address,role,createDate,lastLogin,profile) values(?,?,?,?,?,?,?,?,?,?)");

			prepare.setString(1, user.getName());
			prepare.setString(2, user.getUserName());
			prepare.setString(3, user.getPassword());
			prepare.setString(4, user.getEmail());
			prepare.setString(5,user.getPhoneNumber());
			prepare.setString(6, user.getAddress());
			prepare.setString(7, user.getRole());
			prepare.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			prepare.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			prepare.setBinaryStream(10, new ByteArrayInputStream(user.getProfile()));
			prepare.executeUpdate();
			System.out.println("User Add SuccessFully");

		




	}

	@Override
	public void updateUser(User user) {
		Connection connection =db.getCon();
		try {
			PreparedStatement prepare=connection.prepareStatement("UPDATE User set name=?,password=?,email=?,phoneNumber=?,address=?,lastLogin=? where userid=?");
			prepare.setString(1, user.getName());
			prepare.setString(2, user.getPassword());
			prepare.setString(3, user.getEmail());
			prepare.setString(4,user.getPhoneNumber());
			prepare.setString(5, user.getAddress());
			prepare.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
			prepare.setInt(7,user.getUserId());
			prepare.executeUpdate();
			System.err.print("User Details Updated SuccessFully");



		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

	@Override
	public void deleteUser(String id) {
		Connection connection =db.getCon();
		try {
			PreparedStatement prepare=connection.prepareStatement("DELETE FROM User WHERE email=?");
			prepare.setString(1, id);
			prepare.executeUpdate();
			System.err.print("User is Deleted SuccessFully");



		} catch (SQLException e) {

			e.printStackTrace();
		}



	}
	@Override
	public User getUser(String emai) {
		Connection connection =db.getCon();
		ResultSet res=null;
		User user=null;
		try {
			PreparedStatement prepare=connection.prepareStatement("Select * FROM User WHERE email=?");
			prepare.setString(1, emai);
			res=prepare.executeQuery();

			while(res.next()) {

				int userId=res.getInt(1);
				String name=res.getString(2);
				String userName=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phoneNumber=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createDate=res.getTimestamp(9);
				Timestamp lastLogin=res.getTimestamp(10);
				byte[] profile=res.getBytes(11);
				user=new User(userId, name, userName, password, email, phoneNumber, address, role, createDate, lastLogin,profile);
			}





		} catch (SQLException e) {

			e.printStackTrace();
		}


		return user;
	}

}
