<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.food.models.*,com.food.daoimp.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<link rel="stylesheet" href="orders.css">
</head>
<body>
<%
    User user = (User) session.getAttribute("UserObject");
    List<Order> orders = (List<Order>) request.getAttribute("orders");
%>
<div class="container">
    <h1>Your Orders</h1>
    <% if (orders != null && !orders.isEmpty()) { %>
    <table class="order-items">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Date</th>
                <th>Items</th>
                <th>Total</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
        <% for (Order order : orders) { %>
            <tr>
                <td><%= order.getOrderId() %></td>
                <td><%= order.getOrderDate() %></td>
                <td>
                  <% for (CartItem item : order.getItems()) { %>
                    <div><%= item.getName() %> x <%= item.getQuantity() %></div>
                  <% } %>
                </td>
                <td>&#8377;<%= order.getTotalAmount() %></td>
                <td><%= order.getPaymentMode() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
        <div class="empty">No orders found for <strong><%= user.getName() %></strong>.</div>
    <% } %>
</div>
</body>
</html>