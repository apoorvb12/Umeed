package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeed.daos.NgoDao;
import com.umeed.pojos.Ngo;

/**
 * Servlet implementation class NgoRegistrationServlet
 */
@WebServlet("/NgoRegistrationServlet")
public class NgoRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NgoRegistrationServlet() {
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
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password1");
		String owner_name = request.getParameter("owner_name");
		String owner_mobile = request.getParameter("owner_mobile");
		String owner_email = request.getParameter("owner_email");
		
		Ngo u = new Ngo(name, mobile, email, address, owner_name, owner_mobile, owner_email, password);
		NgoDao ud = new NgoDao();
		
		if(ud.create(u)) {
			response.sendRedirect("Display/NgoLogin.html");
		}
		else {	
			out.println("<html>");
			out.println("<body>");
			out.println("Registration Failed<br><br>");
			out.println("<button onclick=\"window.location.href = 'Display/NgoRegistration.html';\">Sign Up Again</button>");
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}
