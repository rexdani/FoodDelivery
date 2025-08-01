<%@ page import="com.food.models.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%
    Cart cartObj = (Cart) session.getAttribute("cart");
    DecimalFormat df = new DecimalFormat("#.00");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet" href="cart.css">
</head>
<body>
  <div class="container">
    <h1>Your Cart</h1>
    <%
      if (cartObj != null && !cartObj.getAllItems().isEmpty()) {
        for (CartItem item : cartObj.getAllItems()) {
    %>
    <div class="cart-item">
      <!-- Image -->
      <div class="item-image">
        <img src="data:image/jpeg;base64,<%= item.getBase64Image() %>" alt="Item Image">
      </div>

      <!-- Item Info -->
      <div class="item-details">
        <h3><%= item.getName() %></h3>
        <p>Price: &#8377;<%= df.format(item.getPrice()) %></p>

        <!-- Quantity Form -->
        <form id="updateForm-<%= item.getId() %>" action="CartServlet" method="post" class="qty-form">
          <input type="hidden" name="itemId" value="<%= item.getId() %>">
          <input type="hidden" name="quantity" value="<%= item.getQuantity() %>">
          <input type="hidden" name="action" value="update">

          <button type="button" onclick="updateQuantity(<%= item.getId() %>, -1)">-</button>
          <span class="display-qty"><%= item.getQuantity() %></span>
          <button type="button" onclick="updateQuantity(<%= item.getId() %>, 1)">+</button>
        </form>
      </div>

      <!-- Remove -->
      <div class="actions">
        <form action="CartServlet" method="post">
          <input type="hidden" name="itemId" value="<%= item.getId() %>">
          <input type="hidden" name="action" value="delete">
          <button class="remove-btn" type="submit">Remove</button>
        </form>
      </div>
    </div>
    <% } %>
    <div class="total">
      <h3>Total: &#8377;<%= df.format(cartObj.getTotal()) %></h3>
      <a href="checkout.jsp" class="checkout-btn">Proceed to Checkout</a><br><br>
      <a href="menu?hotelId=<%= session.getAttribute("resId") %>" class="checkout-btn">Add More Items</a><br><br>
      <a href="Home" class="checkout-btn">Home</a><br><br>
    </div>
    <% } else { %>
      <p class="empty">Your cart is empty.</p>
    <% } %>
  </div>

  <script>
    function updateQuantity(itemId, delta) {
      const form = document.getElementById("updateForm-" + itemId);
      const qtyInput = form.querySelector("input[name='quantity']");
      const qtySpan = form.querySelector(".display-qty");

      let qty = parseInt(qtyInput.value) + delta;
      if (qty < 1) qty = 1;

      qtyInput.value = qty;
      qtySpan.textContent = qty;
      form.submit();
    }
  </script>
</body>
</html>
