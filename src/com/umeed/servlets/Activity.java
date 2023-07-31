package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeed.daos.DonationDao;
import com.umeed.daos.DonorDetailsDao;
import com.umeed.daos.NgoDao;
import com.umeed.daos.VolunteerDao;
import com.umeed.pojos.Donation;
import com.umeed.pojos.DonorDetails;
import com.umeed.pojos.Ngo;
import com.umeed.pojos.Volunteer;

/**
 * Servlet implementation class Activity
 */
@WebServlet("/Activity")
public class Activity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Activity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"<link rel=\"icon\" href=\"/Umeed/Resources/img/icon.png\" type=\"image/png\">\r\n" + 
				"<title>Activity</title>\r\n" + 
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
				"		<h2>Activity</h2>");
		ArrayList<Volunteer> volunteer = VolunteerDao.findAll();
		ArrayList<DonorDetails> donor = DonorDetailsDao.findAll();
		ArrayList<Ngo> ngo = NgoDao.findAll();
		ArrayList<Donation> donation = DonationDao.findAll();
		
		out.println(" <div class=\"form-group\">\r\n" + 
				"			<p><h4><b style=\"padding-right:40px;color:#ea2c58\">No. of Donors Registered </b>: &nbsp "+donor.size()+"</h4></p> 	\r\n" + 
				"        </div>\r\n" + 
				"        \r\n" + 
				"        <div class=\"form-group\">\r\n" + 
				"			<p><h4><b style=\"padding-right:10px;color:#ea2c58\">No. of Volunteers Connected </b>: &nbsp "+ volunteer.size() +"</h4></p> 	\r\n" + 
				"        </div>\r\n" + 
				"        \r\n" + 
				"		<div class=\"form-group\">\r\n" + 
				"			<p><h4><b style=\"padding-right:63px;color:#ea2c58\">No. of NGO's Affiliated </b>: &nbsp "+ ngo.size() +"</h4></p> 	\r\n" + 
				"        </div>\r\n" + 
				"       <div class=\"form-group\">\r\n" + 
				"				<p><h4><b style=\"padding-right:63px;color:#ea2c58\">No. of Donations Done </b>: &nbsp "+ donation.size() +"</h4></p> 	\r\n" + 
				"	        </div>\r\n" + 
				"	</form>\r\n" + 
				"</div>        \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"				\r\n" + 
				"	<!-- Optional JavaScript -->\r\n" + 
				"	<!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n" + 
				"	<script src=\"/Umeed/Resources/js/jquery-3.2.1.min.js\"></script>\r\n" + 
				"	<script src=\"/Umeed/Resources/js/popper.js\"></script>\r\n" + 
				"	<script src=\"/Umeed/Resources/js/bootstrap.min.js\"></script>\r\n" + 
				"	<!-- <script src=\"/Umeed/Resources/vendors/lightbox/simpleLightbox.min.js\"></script> -->\r\n" + 
				"	<script src=\"/Umeed/Resources/vendors/nice-select/js/jquery.nice-select.min.js\"></script>\r\n" + 
				"	<!-- <script src=\"/Umeed/Resources/vendors/isotope/imagesloaded.pkgd.min.js\"></script> -->\r\n" + 
				"	<script src=\"/Umeed/Resources/vendors/isotope/isotope-min.js\"></script>\r\n" + 
				"	<script src=\"/Umeed/Resources/vendors/owl-carousel/owl.carousel.min.js\"></script>\r\n" + 
				"	<script src=\"/Umeed/Resources/js/jquery.ajaxchimp.min.js\"></script>\r\n" + 
				"	<!-- <script src=\"/Umeed/Resources/vendors/counter-up/jquery.waypoints.min.js\"></script> -->\r\n" + 
				"	<!-- <script src=\"/Umeed/Resources/vendors/flipclock/timer.js\"></script> -->\r\n" + 
				"	<!-- <script src=\"/Umeed/Resources/vendors/counter-up/jquery.counterup.js\"></script> -->\r\n" + 
				"	<script src=\"/Umeed/Resources/js/mail-script.js\"></script>\r\n" + 
				"	<script src=\"/Umeed/Resources/js/custom.js\"></script>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
