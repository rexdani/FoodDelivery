<%@ page import="java.util.List"%>
<%@ page
	import="com.food.models.*,com.food.daoimp.RestaurantImp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
User user=(User)session.getAttribute("UserObject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Komato</title>
<link rel="stylesheet" href="Home.css">
</head>
<body>

	<header class="navbar">
		<div class="logo">Komato</div>
		<nav class="nav-links">
			<a href="Home">Home</a>
			 <a href="cart.jsp">Cart</a>
			 <a href="ViewOrders">Orders</a>
		</nav>
		<div class="profile-photo">
			<img src="data:image/jpeg;base64,<%= user.getBase64Image() %>" alt="Profile Photo">
		</div>
	</header>


	<section class="restaurant-section">
		<h2>Explore</h2>
		<div class="restaurant-list">
			<%
		List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurants");
		if (restaurants != null && !restaurants.isEmpty()) {
		  for (Restaurant r : restaurants) {
	  %>
			<a href="menu?hotelId=<%=r.getRestaurantId()%>" method="post"><div
					class="restaurant-card">
<% String base64Img = r.getBase64Image(); %>
<img src="<%= (base64Img != null && !base64Img.trim().isEmpty()) ? ("data:image/jpeg;base64," + base64Img) : "https://via.placeholder.com/400x250?text=No+Image" %>"
	 alt="Restaurant image" style="background:#ececec; object-fit:cover; width:100%; height:180px;">

					<div class="restaurant-info">
						<h3 class="restaurant-name"><%= r.getName() %></h3>

						<div class="restaurant-meta">
							<span class="rating">⭐ <%= r.getRate() %></span> <span
								class="dot">•</span> <span class="delivery-time">🚴 <%= r.getDeliveryTime() %></span>
						</div>

						<div class="cusine-type">
							🍽
							<%= r.getCusinType() %></div>
					</div>
				</div> </a>
			<%
		  }
		} else {
	  %>
			<p>No restaurants available.</p>
			<%
		}
	  %>
		</div>
	</section>

	<footer class="footer">
		<p>&copy; 2025 Komato. All rights reserved.</p>
	</footer>

</body>
</html>
