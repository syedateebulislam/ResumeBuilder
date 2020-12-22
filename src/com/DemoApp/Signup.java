package com.DemoApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DemoApp.dao.LoginDao;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname").toLowerCase();
		String lname=request.getParameter("lname").toLowerCase();
		String gender=request.getParameter("gender").toLowerCase();
		String country=request.getParameter("country").toLowerCase();
		String email=request.getParameter("email").toLowerCase();
		String password=request.getParameter("password").toLowerCase();
		
		LoginDao dao=new LoginDao();
		
		if(dao.createinDB(fname, lname,gender,country,email,password)) {
			System.out.println("signup successfull");
			response.sendRedirect("Homepage.html");
		}else {
			System.out.println("signup failed");
			response.sendRedirect("Homepage.html");
		}
		
	}
}
