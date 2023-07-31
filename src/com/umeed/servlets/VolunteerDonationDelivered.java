package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeed.daos.DonationDao;
import com.umeed.daos.DonorDetailsDao;
import com.umeed.daos.LocationDao;
import com.umeed.daos.NgoDao;
import com.umeed.pojos.Donation;
import com.umeed.pojos.DonorDetails;
import com.umeed.pojos.Location;
import com.umeed.pojos.Ngo;

/**
 * Servlet implementation class VolunteerDonationDelivered
 */
@WebServlet("/VolunteerDonationDelivered")
public class VolunteerDonationDelivered extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerDonationDelivered() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("volunteerId") != null) {
			PrintWriter out = response.getWriter();	
			out.println("<!doctype html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"	<!-- Required meta tags -->\r\n" + 
					"	<meta charset=\"utf-8\">\r\n" + 
					"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
					"	<link rel=\"icon\" href=\"/Umeed/Resources/img/icon.png\" type=\"image/png\">\r\n" + 
					"	<title>Donations Delivered</title>\r\n" + 
					"	<!-- Bootstrap CSS -->\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/bootstrap.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/vendors/linericon/style.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/font-awesome.min.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/vendors/owl-carousel/owl.carousel.min.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/vendors/lightbox/simpleLightbox.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/vendors/nice-select/css/nice-select.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/vendors/animate-css/animate.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/vendors/jquery-ui/jquery-ui.css\">\r\n" + 
					"	<!-- main css -->\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/style1.css\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/responsive.css\">\r\n" + 
					"	<script src=\"/Umeed/Resources/js/logjs1.js\"></script>\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/logcss3.css\">\r\n" + 
					"	<style>\r\n" + 
					"table {\r\n" + 
					"  width:100%;\r\n" + 
					"}\r\n" + 
					"table, th, td {\r\n" + 
					"  border: 1px solid black;\r\n" + 
					"  border-collapse: collapse;\r\n" + 
					"}\r\n" + 
					"th, td {\r\n" + 
					"  padding: 15px;\r\n" + 
					"  text-align: left;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"table th {\r\n" + 
					"  background-color: #ea2c58;\r\n" + 
					"  color: white;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"	<!--================Header Menu Area =================-->\r\n" + 
					"	<header class=\"header_area\" id=\"home\">\r\n" + 
					"		<div class=\"main_menu\">\r\n" + 
					"			<nav class=\"navbar navbar-expand-lg navbar-light\">\r\n" + 
					"				<div class=\"container\">\r\n" + 
					"					<!-- Brand and toggle get grouped for better mobile display -->\r\n" + 
					"					<a class=\"navbar-brand logo_h\" href=\"\">\r\n" + 
					"						<img src=\"/Umeed/Resources/img/icon.png\" height=\"150\" width=\"150\" alt=\"\">\r\n" + 
					"					</a>\r\n" + 
					"					<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\"\r\n" + 
					"					 aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"						<span class=\"icon-bar\"></span>\r\n" + 
					"						<span class=\"icon-bar\"></span>\r\n" + 
					"						<span class=\"icon-bar\"></span>\r\n" + 
					"					</button>\r\n" + 
					"					<!-- Collect the nav links, forms, and other content for toggling -->\r\n" + 
					"					<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\r\n" + 
					"						<div class=\"row ml-0 w-100\">\r\n" + 
					"							<div class=\"col-lg-12 pr-0\">\r\n" + 
					"								<ul class=\"nav navbar-nav center_nav pull-right\">\r\n" + 
					"									<li class=\"nav-item\">\r\n" + 
					"										<a class=\"nav-link\">Volunteer</a>\r\n" + 
					"									</li>\r\n" + 
					"									<li class=\"nav-item\">\r\n" + 
					"										<a class=\"nav-link\" href=\"/Umeed/VolunteerPending\">Pending Requests</a>\r\n" + 
					"									</li>\r\n" + 
					"									<li class=\"nav-item active\">\r\n" + 
					"										<a class=\"nav-link\">Donations Delivered</a>\r\n" + 
					"									</li>\r\n" + 
					"									<li class=\"nav-item submenu dropdown\">\r\n" + 
					"										<a href=\"#\" class=\"main_btn1\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">"+session.getAttribute("volunteerName")+"</a>\r\n" + 
					"										<ul class=\"dropdown-menu\">\r\n" + 
					"											<li class=\"nav-item\">\r\n" + 
					"												<a class=\"nav-link\" href=\"/Umeed/VolunteerProfile\">Profile</a>\r\n" + 
					"											</li>\r\n" + 
					"											<li class=\"nav-item\">\r\n" + 
					"												<a class=\"nav-link\" href=\"/Umeed/VolunteerLogout\">Log Out</a>\r\n" + 
					"											</li>\r\n" + 
					"										</ul>\r\n" + 
					"									</li>\r\n" + 
					"								</ul>\r\n" + 
					"							</div>\r\n" + 
					"						</div>\r\n" + 
					"					</div>\r\n" + 
					"				</div>\r\n" + 
					"			</nav>\r\n" + 
					"		</div>\r\n" + 
					"	</header>\r\n" + 
					"	<!--================Header Menu Area =================-->\r\n" + 
					"	<br><br><br>\r\n" + 
					"	<div class=\"signup-form2\">\r\n" + 
					"		<form method=\"post\">\r\n" + 
					"			<h2>Donation Delivered</h2>");
			ArrayList<Donation> donation = DonationDao.findAllByVolunteerStatusYes((Integer)session.getAttribute("volunteerId"));
			if(donation.size() != 0) {
				out.println("<table>\r\n" + 
						"				<tr>\r\n" + 
						"					<th>Sr No.</th>\r\n" + 
						"					<th>Donation By</th>\r\n" +  
						"					<th>Pick Up Address</th>\r\n" + 
						"					<th>Donation Type</th>\r\n" + 
						"					<th>Date and Time of Request</th>\r\n" + 
						"					<th>Date and Time of Delivery</th>\r\n" +
						"					<th>NGO Name </th>\r\n" + 
						"					<th>NGO Contact No.</th>\r\n" + 
						"					<th>Address of NGO</th>\r\n" + 
						"				</tr>");
				int i = 1;
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
				for(Donation d : donation) {
					DonorDetails donor = DonorDetailsDao.find(d.getDonorId());
					String date = format.format(d.getDateTime());
					String delivery_date = format.format(d.getDeliveryDate());
					Ngo ngo = NgoDao.find(d.getNgoId());
					Location location = LocationDao.find(d.getLocationId());
					out.println("<tr>\r\n" + 
							"					<td>"+ i++ +"</td>\r\n" + 
							"					<td>"+ donor.getName().toUpperCase() +"</td>\r\n" + 
							"					<td>"+ location.getAddress() +"</td>\r\n" + 
							"					<td>"+ d.getDonationType().toUpperCase() +"</td>\r\n" + 
							"					<td>"+ date +"</td>\r\n" + 
							"					<td>"+ delivery_date +"</td>\r\n" +
							"					<td>"+ ngo.getName().toUpperCase() +"</td>\r\n" + 
							"					<td>"+ ngo.getContactNumber() +"</td>\r\n" + 
							"					<td>"+ ngo.getAddress().toUpperCase() +"</td>\r\n" +  
							"	</tr>");
				}
					out.println("</table>");
			
			}else {
				out.println("<br><p style=\"color:#FF0000\">No Deliveries Done Yet.</p>");
			}
			out.println("</form>\r\n" + 
					"\r\n" + 
					"	</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
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
		}else {
			response.sendRedirect("/Umeed/Display/VolunteerLogin.html");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
