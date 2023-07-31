package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeed.daos.AdminDao;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("User Id : " + email);
		System.out.println("Password : " + password);
		
		int adminId = AdminDao.validate(email, password);
		if(adminId != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("adminId", new Integer(adminId));
			session.setAttribute("adminEmail", email);
//			PrintWriter out = response.getWriter();
//			out.println("<html>"
//					+ "<head>"
//					+ "</head>"
//					+ "<body>"
//					+ "<p>Login Successfull</p>"
//					+ "</body>"
//					+ "</html>");
			response.sendRedirect("AdminPending");
		}else {
			PrintWriter out = response.getWriter();
//			out.println("<html>"
//					+ "<head>"
//					+ "</head>"
//					+ "<body>"
//					+ "<p>Email or Password error</p>"
//					+ "<button type=\"button\" value=\"\" onclick=\"window.location.href= '/Umeed/Display/AdminLogin.html'; \">Try again</button>"
//					+ "</body>"
//					+ "</html>");
			
			
			
			out.println("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"utf-8\">\r\n" + 
					"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700\" rel=\"stylesheet\">\r\n" + 
					"\r\n" + 
					"<link rel=\"icon\" href=\"/Umeed/Resources/img/icon.png\" type=\"image/png\">\r\n" + 
					"<title>Admin Login</title>\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\">\r\n" + 
					"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n" + 
					"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \r\n" + 
					"<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/logcss.css\">\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<div class=\"signup-form\">\r\n" + 
					"    <form action=\"/Umeed/AdminLoginServlet\" method=\"post\" onsubmit=\"return checkPassword(this);\">\r\n" + 
					"		<h2>Login as Admin</h2><p style=\"color:#FF0000\">Email or Password error</p>\r\n" + 
					"        \r\n" + 
					"        <div class=\"form-group\">\r\n" + 
					"        	<input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Email\" required=\"required\">\r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"		<div class=\"form-group\">\r\n" + 
					"            <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" required=\"required\">\r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"		<div class=\"form-group\">\r\n" + 
					"            <button type=\"submit\" class=\"btn btn-success btn-lg btn-block\">Login</button>\r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"        <div class=\"text-center\">Forgot Password? <a href=\"#\">Click here</a></div>\r\n" + 
					"		<div class=\"text-center\">Go To : <a href=\"/Umeed/Display/Home.html\">Home</a></div>\r\n" +
					"    </form>\r\n" + 
					"	\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
			
			
			
			
			
			
			
			
//			response.sendRedirect("/Umeed/Display/AdminLogin.html");
		}
	}

}
