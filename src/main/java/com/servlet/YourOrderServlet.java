package com.servlet;

import java.io.IOException;

import com.food.daoimp.OrdersImp;
import com.food.models.Order;
import com.food.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewOrders")
public class YourOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		        HttpSession session = request.getSession();
		        if (session == null || session.getAttribute("UserObject") == null) {
		            response.sendRedirect("Login.jsp");
		            return;
		        }

		        User user = (User) session.getAttribute("UserObject");

		        try {
		            OrdersImp dao = new OrdersImp();
		            List<Order> orders = dao.getOrdersByUserId(user.getUserId());

		            request.setAttribute("orders", orders);
		            request.getRequestDispatcher("order.jsp").forward(request, response);

		        } catch (Exception e) {
		            e.printStackTrace();
		            response.sendRedirect("error.jsp");
		        }
		    }
		

	}


