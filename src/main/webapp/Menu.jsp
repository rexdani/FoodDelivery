<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.models.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Menu - Komato</title>
  <link rel="stylesheet" href="menu.css">
</head>
<body>

  <header class="navbar">
    <div class="logo">Komato</div>
    <nav>
      <a href="Home">Home</a>
      <a href="orders.jsp">Orders</a>
      <a href="cart.jsp">Cart</a>
    </nav>
  </header>

  <section class="restaurant-header">
    <h1>${Name}</h1>
    <p>Delicious ${cus} Cuisine • ⭐ ${rating} • ⏱ ${Time}mins</p>
  </section>
   <div class="menu-list">
<% 
  List<Menu> items = (List<Menu>) request.getAttribute("menuItems");
  if (items != null) {
    for (Menu item : items) {
%>
  <div class="menu-card">
    <img src="data:image/jpeg;base64,<%= item.getBase64Image() %>" alt="Menu Image">
    <div class="details">
      <h3><%= item.getItemName() %></h3>
      <p class="desc"><%= item.getDescription() %></p>
      <div class="meta">
        <span>₹ <%= item.getPrice()%></span>
        <span>⭐ <%= item.getRating() %></span>
      </div>
      <form action="CartServlet" method="post">
        <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
        <input type="hidden" name="name" value="<%= item.getItemName()%>">
        <input type="hidden" name="resid" value="<%= item.getResturantId()%>">
        <input type="hidden" name="quantity" value="1">
        <input type="hidden" name="price" value="<%= item.getPrice() %>">
        <input type="hidden" name="action" value="add">
        <button type="submit" class="add-btn">Add to Cart</button>
      </form>
    </div>
  </div>
<%
    }
  } else {
%>
  <p class="empty-msg">No items found</p>
<%
  }
%>
</div>
  </section>

</body>
</html>
