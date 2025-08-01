package com.food.daoimp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDao;
import com.food.models.Restaurant;
import com.food.util.db;

public class RestaurantImp implements RestaurantDao {

    @Override
    public List<Restaurant> getAllRestuarant() {
        Connection connection = db.getCon();
        List<Restaurant> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Restuarant");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Restaurant r = new Restaurant(
                    rs.getInt("RestuarantId"),
                    rs.getString("ResturantName"),
                    rs.getString("address"),
                    rs.getString("phoneNumber"),
                    rs.getString("cusinType"),
                    rs.getString("deliveryTime"),
                    rs.getString("adminUserId"),
                    rs.getString("rating"),
                    rs.getBoolean("isActive"),
                    rs.getBytes("Image") // BLOB
                );
                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Restaurant> getAllRestuarant(String name) {
    	Connection connection = db.getCon();
    	List<Restaurant> list = new ArrayList<>();
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Restuarant where ResturantName=?");
    		ps.setString(1, name);
    		ResultSet rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			Restaurant r = new Restaurant(
    					rs.getInt("RestuarantId"),
    					rs.getString("ResturantName"),
    					rs.getString("address"),
    					rs.getString("phoneNumber"),
    					rs.getString("cusinType"),
    					rs.getString("deliveryTime"),
    					rs.getString("adminUserId"),
    					rs.getString("rating"),
    					rs.getBoolean("isActive"),
    					rs.getBytes("Image") // BLOB
    					);
    			list.add(r);
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Connection connection = db.getCon();

        try {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Restuarant (ResturantName, address, phoneNumber, cusinType, deliveryTime, adminUserId, rating, isActive, Image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getAddress());
            ps.setString(3, restaurant.getPhoneNumber());
            ps.setString(4, restaurant.getCusinType());
            ps.setString(5, restaurant.getDeliveryTime());
            ps.setString(6, restaurant.getAdminUserId());
            ps.setString(7, restaurant.getRate());
            ps.setBoolean(8, restaurant.getIsActive());
            ps.setBinaryStream(9, new ByteArrayInputStream(restaurant.getImagePath()));

            ps.executeUpdate();
            System.out.println("Restaurant added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        Connection connection = db.getCon();

        try {
            PreparedStatement ps = connection.prepareStatement(
                "UPDATE Restuarant SET ResturantName=?, address=?, phoneNumber=?, cusinType=?, deliveryTime=?, adminUserId=?, rating=?, isActive=?, Image=? WHERE RestuarantId=?"
            );

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getAddress());
            ps.setString(3, restaurant.getPhoneNumber());
            ps.setString(4, restaurant.getCusinType());
            ps.setString(5, restaurant.getDeliveryTime());
            ps.setString(6, restaurant.getAdminUserId());
            ps.setString(7, restaurant.getRate());
            ps.setBoolean(8, restaurant.getIsActive());
            ps.setBinaryStream(9, new ByteArrayInputStream(restaurant.getImagePath()));
            ps.setInt(10, restaurant.getRestaurantId());

            ps.executeUpdate();
            System.out.println("Restaurant updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        Connection connection = db.getCon();

        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Restuarant WHERE RestuarantId = ?");
            ps.setInt(1, restaurantId);
            ps.executeUpdate();
            System.out.println("Restaurant deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        Connection connection = db.getCon();
        Restaurant restaurant = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Restuarant WHERE RestuarantId = ?");
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                restaurant = new Restaurant(
                    rs.getInt("RestuarantId"),
                    rs.getString("ResturantName"),
                    rs.getString("address"),
                    rs.getString("phoneNumber"),
                    rs.getString("cusinType"),
                    rs.getString("deliveryTime"),
                    rs.getString("adminUserId"),
                    rs.getString("rating"),
                    rs.getBoolean("isActive"),
                    rs.getBytes("Image")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }


public Restaurant getRestaurant(String restaurantId) {
	Connection connection = db.getCon();
	Restaurant restaurant = null;
	
	try {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Restuarant WHERE ResturantName = ?");
		ps.setString(1, restaurantId);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			restaurant = new Restaurant(
					rs.getInt("RestuarantId"),
					rs.getString("ResturantName"),
					rs.getString("address"),
					rs.getString("phoneNumber"),
					rs.getString("cusinType"),
					rs.getString("deliveryTime"),
					rs.getString("adminUserId"),
					rs.getString("rating"),
					rs.getBoolean("isActive"),
					rs.getBytes("Image")
					);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return restaurant;
}
public  List<Restaurant> getRestaurant1(String adminUserID) {
	Connection connection = db.getCon();
	Restaurant restaurant = null;
	List<Restaurant> list = new ArrayList<>();
	
	try {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Restuarant WHERE adminUserId = ?");
		ps.setString(1, adminUserID);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			restaurant = new Restaurant(
					rs.getInt("RestuarantId"),
					rs.getString("ResturantName"),
					rs.getString("address"),
					rs.getString("phoneNumber"),
					rs.getString("cusinType"),
					rs.getString("deliveryTime"),
					rs.getString("adminUserId"),
					rs.getString("rating"),
					rs.getBoolean("isActive"),
					rs.getBytes("Image")
					);
			System.out.println(rs.getInt("RestuarantId")+" "+
					rs.getString("ResturantName")+" "+
					rs.getString("address")+" "+
					rs.getString("phoneNumber")+" "+
					rs.getString("cusinType")+" "+
					rs.getString("deliveryTime")+" "+
					rs.getString("adminUserId")+" "+
					rs.getString("rating")+" "+
					rs.getBoolean("isActive")+" "+
					rs.getBytes("Image"));
			list.add(restaurant);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}
}
