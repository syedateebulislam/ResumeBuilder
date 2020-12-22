package com.DemoApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DemoApp.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String username=request.getParameter("username").toLowerCase();
				String password=request.getParameter("password").toLowerCase();
				System.out.println(username+" "+password);
				
				LoginDao dao=new LoginDao();
				
				//Providing Admin direct access without DB hit for demo
				if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
				{
					System.out.println("admin logged in");
					HttpSession session=request.getSession();
					session.setAttribute("username",username);
					response.sendRedirect("Editpage.jsp");
				}
				else {
					if(dao.readinDb(username, password)) {
						System.out.println(username+" logged in");
						HttpSession session=request.getSession();
						session.setAttribute("username",username);
						response.sendRedirect("Editpage.jsp");
					}
					else {
						System.out.println("invalid credentials");
						response.sendRedirect("Homepage.html");
					}

				}
		}
}
