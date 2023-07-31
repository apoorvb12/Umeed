package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeed.daos.VolunteerDao;
import com.umeed.pojos.Volunteer;

/**
 * Servlet implementation class VolunteerRegistrationServlet
 */
@WebServlet("/VolunteerRegistrationServlet")
public class VolunteerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		
		Volunteer u = new Volunteer(name, mobile, email, password, area, city);
		VolunteerDao ud = new VolunteerDao();
		
		if(ud.create(u)) {
			response.sendRedirect("Display/VolunteerLogin.html");
		}
		else {	
			out.println("<html>");
			out.println("<body>");
			out.println("Registration Failed<br><br>");
			out.println("<button onclick=\"window.location.href = 'Display/VolunteerRegistration.html';\">Sign Up Again</button>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
