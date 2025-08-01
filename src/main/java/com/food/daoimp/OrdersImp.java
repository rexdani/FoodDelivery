package com.food.daoimp;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import com.food.models.Cart;
import com.food.models.CartItem;
import com.food.models.Order;
import com.food.util.db;


public class OrdersImp {
	public void addOrder(Order order)  {
		Connection connection =db.getCon();



		PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("insert into orders(order_id,user_id,total_amount,payment_mode,created_at,CustomerEmail,CustomerName) values(?,?,?,?,?,?,?)");
			prepare.setString(1, order.getOrderId());
			prepare.setInt(2, order.getUserID());
			prepare.setDouble(3, order.getTotalAmount());
			prepare.setString(4, order.getPaymentMode());
			prepare.setString(5,  order.getOrderDate());
			prepare.setString(6,  order.getCustomerEmail());
			prepare.setString(7,  order.getCustomerName());
			prepare.executeUpdate();
			System.out.println("order Add SuccessFully");







		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void   addOrderItem(Cart cart,Order order) {

		Connection connection =db.getCon();


		try {
			for (CartItem item : cart.getAllItems()) {
				String itemSql = "INSERT INTO orderItem (item_id, order_id, product_name,Quantiity,total_amount,user_id) VALUES (?, ?, ?, ?,?,?)";
				PreparedStatement itemPs;
				itemPs = connection.prepareStatement(itemSql);
				itemPs.setInt(1, item.getId());
				itemPs.setString(2, order.getOrderId());
				itemPs.setString(3, item.getName());
				itemPs.setInt(4, item.getQuantity());
				itemPs.setDouble(5, item.getPrice());
				itemPs.setInt(6, order.getUserID());
				
				itemPs.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
		public ArrayList<Order> getOrdersByUserId(int userId) {
	        ArrayList<Order> orders = new ArrayList<>();

	        String orderQuery = "SELECT * FROM orders WHERE user_id = ? ORDER BY created_at DESC";
	        String itemQuery = "SELECT product_name, Quantiity, total_amount " +
	                   "FROM orderItem WHERE order_id = ?";


	        try (Connection conn = db.getCon();
	             PreparedStatement orderStmt = conn.prepareStatement(orderQuery)) {

	            orderStmt.setInt(1, userId);
	            ResultSet rs = orderStmt.executeQuery();

	            while (rs.next()) {
	                Order order = new Order();
	                String orderId = rs.getString("order_id");

	                order.setOrderId(rs.getString("order_id"));
	                order.setUserID(userId);
	                order.setCustomerName(rs.getString("CustomerName"));
	                order.setCustomerEmail(rs.getString("CustomerEmail"));
	                order.setTotalAmount(rs.getDouble("total_amount"));
	                order.setPaymentMode(rs.getString("Status"));

	                Timestamp ts = rs.getTimestamp("created_at");
	                if (ts != null) {
	                    order.setOrderDate(ts.toLocalDateTime().toLocalDate());
	                }

	                // Get items for this order
	                ArrayList<CartItem> items = new ArrayList<>();
	                try (PreparedStatement itemStmt = conn.prepareStatement(itemQuery)) {
	                    itemStmt.setString(1, orderId);
	                    ResultSet itemRs = itemStmt.executeQuery();

	                    while (itemRs.next()) {
	                        CartItem item = new CartItem();
	                        item.setName(itemRs.getString("product_name"));
	                        item.setQuantity(itemRs.getInt("Quantiity"));
	                        item.setPrice(itemRs.getDouble("total_amount"));
	                        items.add(item);
	                        System.out.println(item);
	                    }
	                }
System.out.println(items);
	                order.setItems(items);
	                orders.add(order);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return orders;
	    }
}
