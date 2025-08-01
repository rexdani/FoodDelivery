package com.food.models;

import java.sql.Timestamp;
import java.util.Base64;

public class User {
	private int userId;
	private String name;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String address;
	private String role;
	private Timestamp createDate;
	private Timestamp lastLogin;
	private byte[] profile;
	
	public User(String name, String userName, String password, String email, String phoneNumber, String address,
			String role, Timestamp createDate, Timestamp lastLogin, byte[] profile) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createDate = createDate;
		this.lastLogin = lastLogin;
		this.profile = profile;
	}

	public User() {
		super();
	}

	public User(int userId, String name, String userName, String password, String email, String phoneNumber,
			String address, String role, Timestamp createDate, Timestamp lastLogin, byte[] profile) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createDate = createDate;
		this.lastLogin = lastLogin;
		this.profile = profile;
	}

	public User(String name, String userName, String password, String email, String phoneNumber, String address,
			String role, byte[] profile) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.profile = profile;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public byte[] getProfile() {
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [ "+getUserId()
		        + ","+ getName() + ","
				+ " " + getUserName()
				+ "" + getPassword() 
				+ "" + getEmail() 
				+ ""+ getPhoneNumber() 
				+ "" + getAddress() 
				+ "" + getRole()
				+ "" + getCreateDate() 
				+ "" + getLastLogin() + "]";
	} 
	public String getBase64Image() {
	    try {
	        return Base64.getEncoder().encodeToString(this.profile);
	    } catch (Exception e) {
	        return "";
	    }
	}
	

}
