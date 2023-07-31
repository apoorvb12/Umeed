package com.umeed.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeed.daos.DonationDao;
import com.umeed.pojos.Donation;

/**
 * Servlet implementation class VolunteerPendingSuccess
 */
@WebServlet("/VolunteerPendingSuccess")
public class VolunteerPendingSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerPendingSuccess() {
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

		int donationId = Integer.parseInt(request.getParameter("status"));
		Donation donation = DonationDao.find(donationId);
		donation.setStatus("yes");
		java.util.Date date = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		String dt = df.format(date);
		try {
			date = df.parse(dt);
		}catch(ParseException p) {
			System.out.println("invalid format");
		}
		donation.setDeliveryDate(date);
		DonationDao.edit(donation);
		response.sendRedirect("/Umeed/VolunteerPending");
	}

}
