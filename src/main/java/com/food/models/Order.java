
package com.food.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order {
	private ArrayList<CartItem> items = new ArrayList<>();
	private String orderId;
	private int userID;
	private String CustomerName;
	private String CustomerEmail;
	private double totalAmount;
	private String paymentMode;
	private LocalDate orderDate;
	public Order(String orderId, int userID, String customerName, String customerEmail, double totalAmount,
			String paymentMode, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.userID = userID;
		CustomerName = customerName;
		CustomerEmail = customerEmail;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}



	public Order() {}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderDate() {
		return orderDate+"";
	}

	public void setOrderDate(LocalDate Date) {
		this.orderDate = Date;
	}


	public static String generateOrderNumber() {
		String prefix = "KOM";
		long timestamp = System.currentTimeMillis();
		int random = (int)(Math.random() * 9000) + 1000; // 4-digit random number
		return prefix + timestamp + random;
	}

	public ArrayList<CartItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}



}
