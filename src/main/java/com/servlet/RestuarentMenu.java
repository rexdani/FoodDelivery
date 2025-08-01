package com.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimp.MenuImp;
import com.food.daoimp.RestaurantImp;
import com.food.models.Menu;
import com.food.models.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")
public class RestuarentMenu  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int resId=Integer.parseInt(req.getParameter("hotelId"));
		MenuImp menu=new MenuImp();
		RestaurantImp restaur=new RestaurantImp();
		Restaurant res=restaur.getRestaurant(resId);
		req.setAttribute("rating",res.getRate());
		req.setAttribute("Name",res.getName());
		req.setAttribute("Time",res.getDeliveryTime());
		req.setAttribute("cus",res.getCusinType());
		
		
		List<Menu> li=menu.getAllMenuByID(resId);
		req.setAttribute("menuItems", li);
		resp.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("Menu.jsp");
		rd.include(req, resp);
		
	}

}
