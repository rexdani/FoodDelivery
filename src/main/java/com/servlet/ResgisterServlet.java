package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.food.daoimp.UserImp;
import com.food.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/registeration")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1,
	    maxFileSize = 1024 * 1024 * 10,
	    maxRequestSize = 1024 * 1024 * 15
	)
public class ResgisterServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name=req.getParameter("name");
		String userName=req.getParameter("userName");
		String Password=req.getParameter("password");
		String email=req.getParameter("email");
		String PhoneNumber=req.getParameter("number");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		 Part imagePart = req.getPart("imagePath");
	        InputStream imageStream = imagePart.getInputStream();
	        byte[] imageBytes = imageStream.readAllBytes();
		boolean useradded=true;
		resp.setContentType("text/html");
		String userID=email;
		User user=new User( Name, userID, Password, email, PhoneNumber, address, role,imageBytes);
		UserImp imp=new UserImp();
		try {
			imp.addUser(user);
		} catch (SQLException e) {
			useradded=false;
			req.setAttribute("message","***Email Alredy Exist....." );
			RequestDispatcher rd=req.getRequestDispatcher("Registeration.jsp");
			rd.include(req, resp);
			
			
		}
		if(useradded) {
		req.setAttribute("name", Name);
		req.setAttribute("userName", userID);
		RequestDispatcher rd=req.getRequestDispatcher("Sucess.jsp");
		rd.include(req, resp);
		}
		}
}
