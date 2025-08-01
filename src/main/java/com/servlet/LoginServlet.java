package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;

import com.food.daoimp.UserImp;
import com.food.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/CallingLogin")
public class LoginServlet extends HttpServlet{
	byte count=3;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserImp imp=new UserImp();
		String userName=req.getParameter("userName");
		String loginPassword=req.getParameter("password");
		User user=imp.getUser(userName);
        resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		if(user!=null) {
		if(loginPassword.equals(user.getPassword())) {
			req.setAttribute("name", user.getName());
			req.setAttribute("status", user.getRole());
			req.setAttribute("username", user.getUserName());
			req.setAttribute("userId", user.getUserId());
	        req.setAttribute("email", user.getEmail());
	        req.setAttribute("address", user.getAddress());
	        req.setAttribute("role", user.getRole());
	        req.setAttribute("number", user.getPhoneNumber());
	        HttpSession ses=req.getSession();
			ses.setAttribute("name", userName);
			ses.setAttribute("Fullname", user.getName());
			ses.setAttribute("password", user.getPassword());
			ses.setAttribute("status", user.getRole());
			ses.setAttribute("username", user.getUserName());
			ses.setAttribute("userId", user.getUserId());
			ses.setAttribute("email", user.getEmail());
			ses.setAttribute("address", user.getAddress());
			ses.setAttribute("role", user.getRole());
			ses.setAttribute("number", user.getPhoneNumber());
			ses.setAttribute("UserObject", user);
			RequestDispatcher rd=req.getRequestDispatcher("Home");
			rd.include(req, resp);
		}
		else if(count>0) {
			req.setAttribute("message","Check the Email Invalid Password "+count+" Attempt left" );
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.include(req, resp);
			count--;
		}
		else {
			out.println("Contact the admin. thank you");
		}
		}
		else {
			req.setAttribute("message","*Account Not Found !" );
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.include(req, resp);
		}
		
	}

}
