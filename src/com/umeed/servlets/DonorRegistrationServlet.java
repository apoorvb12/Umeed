package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeed.daos.DonorDetailsDao;
import com.umeed.pojos.DonorDetails;

/**
 * Servlet implementation class DonorRegistrationServlet
 */
@WebServlet("/DonorRegistrationServlet")
public class DonorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DonorRegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath())
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		
		DonorDetails u = new DonorDetails( name, mobile,email, password);
		DonorDetailsDao ud = new DonorDetailsDao();
		
		if(ud.create(u)) {
			response.sendRedirect("Display/DonorLogin.html");
		}
		else {	
			out.println("<html>");
			out.println("<body>");
			out.println("Registration Failed<br><br>");
			out.println("<button onclick=\"window.location.href = 'Display/DonorRegistration.html';\">Sign Up Again</button>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
