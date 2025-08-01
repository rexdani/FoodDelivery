package com.food.models;

import java.util.Base64;

import jakarta.servlet.http.Part;

public class Menu {
private int menuId;
private int ResturantId;
private String itemName;
private String description;
private int price;
private String isAvailable;
private String rating;
private byte[] imagePath;
public Menu(int menuId, int resturantId, String itemName, String description, int price, String isAvailable,
		String rating, byte[] imagePath) {
	super();
	this.menuId = menuId;
	ResturantId = resturantId;
	this.itemName = itemName;
	this.description = description;
	this.price = price;
	this.isAvailable = isAvailable;
	this.rating = rating;
	this.imagePath = imagePath;
}
public Menu(int resturantId, String itemName, String description, int price, String isAvailable, String rating,
		byte[] imagePath) {
	super();
	ResturantId = resturantId;
	this.itemName = itemName;
	this.description = description;
	this.price = price;
	this.isAvailable = isAvailable;
	this.rating = rating;
	this.imagePath = imagePath;
}
public Menu() {
	super();
}
public int getMenuId() {
	return menuId;
}
public void setMenuId(int menuId) {
	this.menuId = menuId;
}
public int getResturantId() {
	return ResturantId;
}
public void setResturantId(int resturantId) {
	ResturantId = resturantId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getIsAvailable() {
	return isAvailable;
}
public void setIsAvailable(String isAvailable) {
	this.isAvailable = isAvailable;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public byte[] getImagePath() {
	return imagePath;
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
