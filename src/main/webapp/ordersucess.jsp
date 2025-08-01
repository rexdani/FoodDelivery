<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.food.models.Order" %>
<%
    Order order = (Order) request.getAttribute("order");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: #ececec;
            font-family: 'Segoe UI', sans-serif;
            color: #385170;
        }

        .container {
            max-width: 600px;
            margin: 80px auto;
            background-color: #9fd3c7;
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 0 20px rgba(56, 81, 112, 0.08);
            text-align: center;
        }

        h1 {
            font-size: 32px;
            margin-bottom: 20px;
            color: #142d4c;
        }

        p {
            font-size: 18px;
            margin: 10px 0;
            color: #385170;
        }

        .home-button {
            margin-top: 30px;
        }

        .home-button a {
            text-decoration: none;
            padding: 12px 24px;
            background: #385170;
            color: #ececec;
            font-weight: bold;
            border-radius: 8px;
            transition: background 0.3s ease;
        }

        .home-button a:hover {
            background: #142d4c;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>🎉 Order Placed Successfully!</h1>
    <p><strong>Order ID:</strong> <%= order.getOrderId() %></p>
    <p><strong>Name:</strong> <%= order.getCustomerName() %></p>
    <p><strong>Email:</strong> <%= order.getCustomerEmail() %></p>
    <p><strong>Total Amount:</strong> ₹<%= order.getTotalAmount() %></p>

    <div class="home-button">
        <a href="Home">Continue Shopping</a>
    </div>
</div>

</body>
</html>
