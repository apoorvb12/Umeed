package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeed.daos.DonorDetailsDao;
import com.umeed.pojos.DonorDetails;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/DonorProfileServlet")
public class DonorProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int donorId = 0;
		if (session.getAttribute("donorId") != null) {
			donorId = (Integer) session.getAttribute("donorId");
			DonorDetails donor = DonorDetailsDao.find(donorId);	
			
			PrintWriter out = response.getWriter();
			
			out.println("<!doctype html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"	<!-- Required meta tags -->\r\n" + 
					"	<meta charset=\"utf-8\">\r\n" + 
					"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
					"	<link rel=\"icon\" href=\"/Umeed/Resources/img/icon.png\" type=\"image/png\">\r\n" + 
					"	<title>Donor Profile</title>\r\n" + 
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
					"	\r\n" + 
					"	<link rel=\"stylesheet\" href=\"/Umeed/Resources/css/logcss1.css\">\r\n" + 
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
					"										<a class=\"nav-link\" href=\"/Umeed/DonateNowServlet\">Donate Now</a>\r\n" + 
					"									</li>\r\n" + 
					"									<li class=\"nav-item \">\r\n" + 
					"										<a class=\"nav-link\" href=\"/Umeed/DonorCurrentStatus\">Current/Pending Status</a>\r\n" + 
					"									</li>\r\n" + 
					"									<li class=\"nav-item \">\r\n" + 
					"										<a class=\"nav-link\" href=\"/Umeed/DonationHistory\">Donation History</a>\r\n" + 
					"									</li>\r\n" + 
					"									<li class=\"nav-item submenu dropdown\">\r\n" + 
					"										<a href=\"#\" class=\"main_btn1\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">"+ (String)session.getAttribute("donorName") +"</a>\r\n" + 
					"										<ul class=\"dropdown-menu\">\r\n" + 
					"											<li class=\"nav-item\">\r\n" + 
					"												<a class=\"nav-link\">Profile</a>\r\n" + 
					"											</li>\r\n" + 
					"											<li class=\"nav-item\">\r\n" + 
					"												<a class=\"nav-link\" href=\"/Umeed/DonorLogout\">Log Out</a>\r\n" + 
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
					"	<div class=\"signup-form\">\r\n" + 
					"    <form  method=\"post\" action=\"/Umeed/DonorChangePassword\">\r\n" + 
					"		<h2>Profile</h2><br>\r\n" + 
					"        <div class=\"form-group\">\r\n" + 
					"			<p><h4><b style=\"padding-right:78px;color:#ea2c58\">Name </b>: &nbsp" + donor.getName() + "</h4></p> 	\r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"        <div class=\"form-group\">\r\n" + 
					"			<p><h4><b style=\"padding-right:31px;color:#ea2c58\">Contact No. </b>: &nbsp" + donor.getContactNumber() + "</h4></p> 	\r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"        <div class=\"form-group\">\r\n" + 
					"			<p><h4><b style=\"padding-right:82px;color:#ea2c58\">Email </b>: &nbsp" + donor.getEmail() + "</h4></p> 	\r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"        <div class=\"form-group\">\r\n" + 
					"			<p><h4><b  style=\"padding-right:10px;color:#ea2c58\">Total Donation </b>: &nbsp0" + DonorDetailsDao.donationCount(donorId) + "</h4></p> 	\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"form-group\">\r\n" + 
					"            <button type=\"submit\" style=\"width:50%\"  class=\"btn btn-success btn-lg btn-block\">Change Password</button>\r\n" + 
					"        </div></form>\r\n" + 
					"        \r\n" + 
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
			
		}else {
			response.sendRedirect("/Umeed/Display/DonorLogin.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
