package com.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimp.RestaurantImp;
import com.food.models.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/getHotel")
public class SearchbyName extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hotell=req.getParameter("hotel");
		RestaurantImp hotel=new RestaurantImp();
		List<Restaurant> li=hotel.getAllRestuarant(hotell);
		req.setAttribute("restaurants", li);
		resp.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.include(req, resp);
	}

}
