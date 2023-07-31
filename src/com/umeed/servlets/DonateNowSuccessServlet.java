package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeed.daos.DonationDao;
import com.umeed.daos.LocationDao;
import com.umeed.pojos.Donation;
import com.umeed.pojos.Location;

/**
 * Servlet implementation class DonateNowSuccessServlet
 */
@WebServlet("/DonateNowSuccessServlet")
public class DonateNowSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateNowSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int donorId = (int)session.getAttribute("donorId");
		
		String donationType = request.getParameter("donation_type");
		
		String ngoId1 = request.getParameter("ngo_id");
		int ngoId = Integer.parseInt(ngoId1);
		
		String volunteerId1 = request.getParameter("volunteer_id");
		int volunteerId = Integer.parseInt(volunteerId1);
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		String dt = df.format(date);
		try {
			date = df.parse(dt);
		}catch(ParseException p) {
			System.out.println("invalid format");
		}
		String location = request.getParameter("address1").trim().toUpperCase() + " " + request.getParameter("address2").trim().toUpperCase();
		Location loc = new Location(location.trim());
		LocationDao.create(loc);
			int locationId = LocationDao.getId(location);
			Donation d = new Donation(donationType, date, ngoId, donorId, volunteerId,locationId,"no");
			DonationDao dd = new DonationDao();
			if(dd.create(d)) {
				response.sendRedirect("DonateNowServlet");
			}else {
				PrintWriter out = response.getWriter();
				out.println("Request for donation failed!");
			}
		
		
	}

}
