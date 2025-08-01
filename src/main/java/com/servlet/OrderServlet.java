package com.servlet;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.security.Provider.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import com.food.daoimp.OrdersImp;
import com.food.daoimp.UserImp;
import com.food.models.Cart;
import com.food.models.CartItem;
import com.food.models.Order;
import com.food.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/placeorder")
public class OrderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null || cart.getAllItems().isEmpty()) {
			response.sendRedirect("cart.jsp");
			return;
		}
		String customerName = request.getParameter("name");
		String customerEmail =(String)session.getAttribute("email");
		String orderId=Order.generateOrderNumber();
		UserImp user=new UserImp();
		User us=user.getUser(customerEmail);
		int userID=us.getUserId();
		String paymentMode=request.getParameter("paymentMethod");
		LocalDate orderDate=LocalDate.now();
		double totalAmount = cart.getTotal();
		Order order = new Order(orderId, userID, customerName, customerEmail, totalAmount, paymentMode, orderDate);
		OrdersImp or=new OrdersImp();
		or.addOrder(order);
		or.addOrderItem(cart, order);
		 session.removeAttribute("cart");  // Clear cart
         request.setAttribute("order", order);
         request.getRequestDispatcher("ordersucess.jsp").forward(request, response);


	}

}
