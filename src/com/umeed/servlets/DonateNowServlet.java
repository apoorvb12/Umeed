package com.umeed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeed.pojos.Ngo;
import com.umeed.pojos.Volunteer;
import com.umeed.daos.NgoDao;
import com.umeed.daos.VolunteerDao;

/**
 * Servlet implementation class DonateNowServlet
 */
@WebServlet("/DonateNowServlet")
public class DonateNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateNowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		int donorId = 0;
		String donorName = new String();
		String donorEmail = new String();
		if (session.getAttribute("donorId") != null) {
			donorId = (Integer) session.getAttribute("donorId");
			donorName = (String) session.getAttribute("donorName");
			donorEmail = (String) session.getAttribute("donorEmail");
		
		
		
		
		out.println("<!doctype html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"	<!-- Required meta tags -->\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"	<link rel=\"icon\" href=\"/Umeed/Resources/img/icon.png\" type=\"image/png\">\r\n" + 
				"	<title>Donate Now</title>\r\n" + 
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
				"									<li class=\"nav-item active\">\r\n" + 
				"										<a class=\"nav-link\" >Donate Now</a>\r\n" + 
				"									</li>\r\n" + 
				"									<li class=\"nav-item \">\r\n" + 
				"										<a class=\"nav-link\" href=\"DonorCurrentStatus\">Current/Pending Status</a>\r\n" + 
				"									</li>\r\n" + 
				"									<li class=\"nav-item \">\r\n" + 
				"										<a class=\"nav-link\" href=\"DonationHistory\">Donation History</a>\r\n" + 
				"									</li>\r\n" + 
				"									<li class=\"nav-item submenu dropdown\">\r\n" + 
				"										<a href=\"#\" class=\"main_btn1\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">"+donorName+"</a>\r\n" + 
				"										<ul class=\"dropdown-menu\">\r\n" + 
				"											<li class=\"nav-item\">\r\n" + 
				"												<a class=\"nav-link\" href=\"DonorProfileServlet\">Profile</a>\r\n" + 
				"											</li>\r\n" + 
				"											<li class=\"nav-item\">\r\n" + 
				"												<a class=\"nav-link\" href=\"DonorLogout\">Log Out</a>\r\n" + 
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
				"    <form  method=\"post\" action=\"/Umeed/DonateNowSuccessServlet\">\r\n" + 
				"		<h2>Donation Form</h2>\r\n" + 
				"        \r\n" + 
				"			<select name=\"donation_type\" class=\"form-group\" required=\"required\">\r\n" + 
				"				<option value=\"\" disabled selected>Choose Donation Type</option>\r\n" + 
				"  				<option value=\"food\">Left over Food</option>\r\n" + 
				" 				<option value=\"clothes\">Clothes</option>\r\n" + 
				"  				<option value=\"blankets\">Blanklets</option>\r\n" + 
				"  				<option value=\"grocery\">Grocery</option>\r\n" + 
				"  				<option value=\"utensils\">Utensils</option>\r\n" + 
				"  				<option value=\"other\">Other</option>\r\n" + 
				"				</select> 	\r\n" + 
				"        \r\n" + 
				"        \r\n" + 
				"        <div class=\"form-group\">\r\n" + 
				"				<input type=\"text\" class=\"form-control\" name=\"address1\"\r\n" + 
				"					placeholder=\"Address Line 1\" required=\"required\">\r\n" + 
				"			</div>\r\n" + 
				"        \r\n" + 
				"        <div class=\"form-group\">\r\n" + 
				"        	<input type=\"text\" class=\"form-control\" name=\"address2\" placeholder=\"Address Line 2 (Optional)\">\r\n" + 
				"        </div>\r\n" + 
				"        \r\n" + 
				
				"        <select class=\"form-group\" name=\"ngo_id\" required=\"required\">\r\n" + 
				"				<option value=\"\" disabled selected>Choose NGO</option>\r\n" ); 
				NgoDao ngo = new NgoDao();
				ArrayList<Ngo> ngoList = ngo.findAll();
				for (Ngo name : ngoList) {
					out.println("<option value=\"" + name.getNgoId() + "\">" + name.getName() + "</option>");
				}
				
				
				out.println("				</select>\r\n" );
				
				
				out.println("<select class=\"form-group\" name=\"volunteer_id\" required=\"required\">\r\n" + 
						"				<option value=\"\" disabled selected>Choose: Volunteer &nbsp-&nbsp Area</option>\r\n");
				
				VolunteerDao volunteer = new VolunteerDao();
				ArrayList<Volunteer> volunteerList = volunteer.findAll();
				for (Volunteer name : volunteerList) {
					out.println("<option value=\"" + name.getVolunteerId() + "\">" + name.getName() + " &nbsp-&nbsp " + name.getArea()
								+ "</option>");
				}
				
				out.println("				</select>\r\n" +
				"				\r\n" + 
				"		<div class=\"form-group\">\r\n" + 
				"            <button type=\"submit\" class=\"btn btn-success btn-lg btn-block\">Donate</button>\r\n" + 
				"        </div>\r\n" + 
				"    </form>\r\n" + 
				"	\r\n" + 
				"</div>\r\n" + 
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
		
	}

}
