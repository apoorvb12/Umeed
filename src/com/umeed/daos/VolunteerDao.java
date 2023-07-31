package com.umeed.daos;

import java.sql.*;
import java.util.*;
import com.umeed.utilities.*;
import com.umeed.pojos.*;
public class VolunteerDao {

	public boolean create(Volunteer volunteer) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "insert into volunteerdetails (Name,Contact_Number,Email,Password,Area,city)values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, volunteer.getName());
			ps.setString(2, volunteer.getContactNumber());
			ps.setString(3, volunteer.getEmail());
			ps.setString(4, volunteer.getPassword());
			ps.setString(5, volunteer.getArea());
			ps.setString(6, volunteer.getCity());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean edit(Volunteer volunteer) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "update volunteerdetails set Name=? ,Contact_Number=? ,Email=?,Area=?,city=? , Password=? where Volunteer_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, volunteer.getName());
			ps.setString(2, volunteer.getContactNumber());
			ps.setString(3, volunteer.getEmail());
			ps.setString(4, volunteer.getArea());
			ps.setString(5, volunteer.getCity());
			ps.setString(6, volunteer.getPassword());
			ps.setDouble(7, volunteer.getVolunteerId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean remove(int volunteerId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "Delete from volunteerdetails where Volunteer_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, volunteerId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static Volunteer find(int volunteerId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Volunteer volunteer = new Volunteer();
		try {
			String sql = "select * from volunteerdetails where Volunteer_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				volunteer.setVolunteerId(rs.getInt(1));
				volunteer.setName(rs.getString(2));
				volunteer.setContactNumber(rs.getString(3));
				volunteer.setEmail(rs.getString(4));
				volunteer.setPassword(rs.getString(5));
				volunteer.setArea(rs.getString(6));
				volunteer.setCity(rs.getString(7));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return volunteer;
	}

	public static ArrayList<Volunteer> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Volunteer> listvolunteer = new ArrayList<Volunteer>();
		try {
			String sql = "select * from volunteerdetails";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Volunteer volunteer = new Volunteer();
				volunteer.setVolunteerId(rs.getInt(1));
				volunteer.setName(rs.getString(2));
				volunteer.setContactNumber(rs.getString(3));
				volunteer.setEmail(rs.getString(4));
				volunteer.setPassword(rs.getString(5));
				volunteer.setArea(rs.getString(6));
				volunteer.setCity(rs.getString(7));
				listvolunteer.add(volunteer);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listvolunteer;
	}
	
	public static int validate(String email,String password) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select Volunteer_Id from volunteerdetails where Email = ? and Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				id = rs.getInt("Volunteer_Id");
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}	
		return id;
	}
	
	public static boolean checkPassword(String password, int volunteerId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		String pass = new String();
		try {
			String sql = "select Password from volunteerdetails where Volunteer_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				pass = rs.getString("Password");
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return pass.equals(password);
	}

	
	public static void changeVolunteerPassword(String password, int volunteerId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update volunteerdetails set Password=? where Volunteer_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, volunteerId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public static int donationReceived(int volunteerId) {
		int count = 0;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select count(*) from donation where Volunteer_Id = ? and status='yes'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				count = rs.getInt("count(*)");
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}	
		return count;
	}

	public static void main(String args[]) {
		
		
//		 Volunteer volunteer = new Volunteer( "afafafdf", "3653278562" , "safhjh@gmaIL.com", "sdfsdfs", "sdgsdg","asd");
//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 volunteerDao.create(volunteer);

//		 Volunteer volunteer = new Volunteer(2007, "afafafdf", "46446456" , "safhjh@gmaIL.com", "sdfsdfs", "agra","bhoapl");
//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 volunteerDao.edit(volunteer);

//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 Volunteer volunteer = volunteerDao.find(2001);
//		 System.out.println(volunteer);

//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 ArrayList<Volunteer> al = volunteerDao.findAll();
//		 for (Volunteer volunteer : al)
//		 System.out.println(volunteer);

//		 Volunteer volunteer = new Volunteer(2007, "daredevil");
//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 volunteerDao.changeVolunteerPassword(volunteer);
		
//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 volunteerDao.remove(2007);

	}

}

