<%@ page import="com.food.models.*" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    DecimalFormat df = new DecimalFormat("#.00");
%>
<%
User user=(User)session.getAttribute("UserObject");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="checkout.css">
</head>
<body>
<div class="checkout-container">
    <h1>Checkout</h1>

    <% if (cart != null && !cart.getAllItems().isEmpty()) { %>

    <table class="checkout-table">
        <thead>
        <tr>
            <th>Item</th>
            <th>Image</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <% for (CartItem item : cart.getAllItems()) { %>
            <tr>
                <td><%= item.getName() %></td>
                <td><img src="data:image/jpeg;base64,<%= item.getBase64Image() %>" alt="Image"></td>
                <td>&#8377;<%= df.format(item.getPrice()) %></td>
                <td><%= item.getQuantity() %></td>
                <td>&#8377;<%= df.format(item.getPrice() * item.getQuantity()) %></td>
            </tr>
        <% } %>
        </tbody>
    </table>

    <div class="checkout-summary">
        <h3>Total: &#8377;<%= df.format(cart.getTotal()) %></h3>
    </div>

    <!-- Order Form -->
    <form action="placeorder" method="post" class="order-form">
        <h2>Customer Details</h2>

        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" value="<%=user.getName()%>" readonly style="background:#ececec; color:#385170;">

        <label for="mobile">Mobile Number</label>
        <input type="tel" id="mobile" name="mobile" value="<%=user.getPhoneNumber()%>" readonly style="background:#ececec; color:#385170;">

        <label for="address">Delivery Address</label>
        <textarea id="address" name="address" rows="3" readonly style="background:#ececec; color:#385170;"><%=user.getAddress()%></textarea>

        <h2>Payment Method</h2>
        <div class="payment-options">
            <label><input type="radio" name="paymentMethod" value="COD" required> Cash on Delivery</label>
            <label><input type="radio" name="paymentMethod" value="UPI"> UPI</label>
            <label><input type="radio" name="paymentMethod" value="NetBanking"> Net Banking</label>
            <label><input type="radio" name="paymentMethod" value="Card"> Credit/Debit Card</label>
        </div>

        <button type="submit" class="place-order-btn">Place Order</button>
        <a href="cart.jsp" class="back-cart-btn">Back to Cart</a>
    </form>

    <% } else { %>
        <p class="empty-cart-msg">Your cart is empty. <a href="menu?hotelId=<%=session.getAttribute("resId")%>">Go back to menu</a>.</p>
    <% } %>
</div>
</body>
</html>
