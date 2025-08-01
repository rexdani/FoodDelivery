package com.food.models;

import java.util.Base64;

public class CartItem {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private byte[] imagePath;
    private String orderId;

    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public CartItem() {}

    public CartItem(int id, String name, double price, int quantity, byte[] imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public byte[] getImagePath() {
        return imagePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImagePath(byte[] imagePath) {
        this.imagePath = imagePath;
    }

    public String getBase64Image() {
        try {
            return Base64.getEncoder().encodeToString(this.imagePath);
        } catch (Exception e) {
            return "";
        }
    }
}
