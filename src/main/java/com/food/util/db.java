package com.food.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	
	
 static String url="jdbc:mysql://avnadmin@daniyal2004-rexdaniyal-a25b.b.aivencloud.com:23752/Swiggy";
 static String user="avnadmin";
 static String password="AVNS_xsJNPS3ob6PvDZhlVFF";
  static Connection connection;

 public static Connection getCon() {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url, user, password);
	 } catch (ClassNotFoundException e) {
		e.printStackTrace();
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return connection;
	 
 }
 public static Connection getCon2() {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "root");
	 } catch (ClassNotFoundException e) {
		e.printStackTrace();
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return connection;
	 
 }
 
}
