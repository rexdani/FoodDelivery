package com.food.daoimp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDao;
import com.food.models.Menu;
import com.food.util.db;

import jakarta.servlet.http.Part;

public class MenuImp implements MenuDao{

	@Override
	public List<Menu> getAllMenu() {
		Connection connection =db.getCon();
		ArrayList<Menu> li=new ArrayList<Menu>();
		Menu menu=null;
		try {
			PreparedStatement prepare=connection.prepareStatement("Select * FROM menu");
			ResultSet res=prepare.executeQuery();
			while(res.next()) {
				int menuNo=res.getInt(1);
				int ResturantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int price=res.getInt(5);
				String isAvailable=res.getString(6);
				String rating=res.getString(7);
				byte[] imagePath=res.getBytes(8);
				menu=new Menu(menuNo, ResturantId, itemName, description, price, isAvailable, rating, imagePath);
				li.add(menu);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}


		return li;
	}


	public List<Menu> getAllMenuByID(int id) {
		Connection connection =db.getCon();
		ArrayList<Menu> li=new ArrayList<Menu>();
		Menu menu=null;
		try {
			PreparedStatement prepare=connection.prepareStatement("Select * FROM Menu where RestuarantId=?");
			prepare.setInt(1, id);
			ResultSet res=prepare.executeQuery();
			while(res.next()) {
				int menuNo=res.getInt(1);
				int ResturantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int price=res.getInt(5);
				String isAvailable=res.getString(6);
				String rating=res.getString(7);
				byte[] imagePath=res.getBytes(8);
				menu=new Menu(menuNo, ResturantId, itemName, description, price, isAvailable, rating, imagePath);
				li.add(menu);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}


		return li;
	}


	@Override
	public void addMenu(Menu menu) {
		Connection Connection=db.getCon();
		try {
			PreparedStatement preparedStatement=Connection.prepareStatement("insert into Menu (RestuarantId,itemName,description,price,isAvaiable,rating,Image) values(?,?,?,?,?,?,?)");

			preparedStatement.setInt(1, menu.getResturantId());	
			preparedStatement.setString(2, menu.getItemName());	
			preparedStatement.setString(3, menu.getDescription());	
			preparedStatement.setInt(4, menu.getPrice());	
			preparedStatement.setString(5, menu.getIsAvailable());	
			preparedStatement.setString(6,menu.getRating());

			preparedStatement.setBinaryStream(7, new ByteArrayInputStream(menu.getImagePath()));			
			preparedStatement.executeUpdate();
			System.err.print("menu Add SuccessFully");


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateMenu(Menu menu) {
		Connection connection =db.getCon();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("UPDATE `Menu` SET `menuId` =?,`RestuarantId`= ?,`itemName`= ?,`description` = ?,`price` = ?,`isAvaiable` = ?,`rating` = ? ,`Image` = ? WHERE `menuId` = ?");
			preparedStatement.setInt(1, menu.getResturantId());	
			preparedStatement.setString(2, menu.getItemName());	
			preparedStatement.setString(3, menu.getDescription());	
			preparedStatement.setString(4, menu.getIsAvailable());	
			preparedStatement.setInt(5, menu.getPrice());	
			preparedStatement.setString(6,menu.getRating());
			preparedStatement.setBinaryStream(7, new ByteArrayInputStream(menu.getImagePath()));		

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId) {
		Connection connection =db.getCon();
		try {
			PreparedStatement prepare=connection.prepareStatement("DELETE FROM Menu WHERE MenuId=?");
			prepare.setInt(1, menuId);
			prepare.executeUpdate();
			System.out.print("Menu is Deleted SuccessFully");
		}catch (SQLException e) {

			e.printStackTrace();
		}


	}

	@Override
	public Menu getMenu(int menuId) {
		Connection connection =db.getCon();
		ResultSet res=null;
		Menu menu =null;
		try {
			PreparedStatement prepare=connection.prepareStatement("Select * FROM Menu WHERE menuId=?");
			prepare.setInt(1, menuId);
			res=prepare.executeQuery();
			while(res.next()) {
				int menuNo=res.getInt(1);
				int ResturantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int price=res.getInt(5);
				String isAvailable=res.getString(6);
				String rating=res.getString(7);
				byte[] imagePath=res.getBytes(8);
				menu=new Menu(menuNo, ResturantId, itemName, description, price, isAvailable, rating, imagePath);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}


		return menu;
	}

}
