package com.food.models;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import jakarta.servlet.http.Part;

public class Restaurant  {
	private int restaurantId;
	private String name;
	private String address;
	private String phoneNumber;
	private String cusinType;
	private String deliveryTime;
	private String adminUserId;
	private String rate;
	private Boolean isActive;
	private byte[] imagePath;
	
	
	public String getBase64Image() {
	    try {
	        return Base64.getEncoder().encodeToString(this.imagePath);
	    } catch (Exception e) {
	        return "";
	    }
	}

	public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cusinType,
			String deliveryTime, String adminUserId, String rate, Boolean isActive, byte[] imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cusinType = cusinType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rate = rate;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	public Restaurant(String name, String address, String phoneNumber, String cusinType, String deliveryTime,
			String adminUserId, String rate, Boolean isActive, byte[] imagePath) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cusinType = cusinType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rate = rate;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCusinType() {
		return cusinType;
	}

	public void setCusinType(String cusinType) {
		this.cusinType = cusinType;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public byte[] getImagePath() {
		return imagePath;
	}

	public void setImagePath(byte[] imagePath) {
		this.imagePath = imagePath;
	}
	

}
