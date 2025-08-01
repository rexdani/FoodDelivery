<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.food.models.*,com.food.daoimp.*,java.util.*"%>
<%RestaurantImp r=new RestaurantImp();
String email=(String)session.getAttribute("email");
List<Restaurant> hotel=r.getRestaurant1(email);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Menu Item</title>
<link rel="stylesheet" href="addMenu.css">
</head>

<body>
	<div class="form-container">
		<h1>Add Menu Item</h1>
		<form action="addMenu" method="post" enctype="multipart/form-data">
			<label>Restaurant Name</label> <select name="restaurantId" required>
				<%
     for(Restaurant res:hotel){
     %>
				<option value=<%=res.getRestaurantId() %>><%=res.getName() %></option>
				<%
        }
        %>
			</select> <label>Item Name</label> <input type="text" name="itemName" required>

			<label>Description</label>
			<textarea name="description" rows="3" required></textarea>

			<label>Price</label> <input type="text" name="price" required>

			<label>Available?</label> <select name="isAvailable" required>
				<option value="available">Yes</option>
				<option value="not available">No</option>
			</select> <label>Rating</label> <input type="text" name="rating" required>

			<label>Image</label> <input type="file" name="imagePath"
				accept="image/*" required>

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
