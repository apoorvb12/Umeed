package com.umeed.daos;

import java.sql.*;
import java.util.*;
import com.umeed.utilities.*;
import com.umeed.pojos.*;
public class DonorDetailsDao {

	public boolean create(DonorDetails donor) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "insert into donordetails (Name,Contact_Number,Email,Password)values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, donor.getName());
			ps.setString(2, donor.getContactNumber());
			ps.setString(3, donor.getEmail());
			ps.setString(4, donor.getPassword());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean edit(DonorDetails donor) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "update donordetails set Name=? ,Contact_Number=? ,Email=?,Password=? where Donor_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, donor.getName());
			ps.setString(2, donor.getContactNumber());
			ps.setString(3, donor.getEmail());
			ps.setString(4, donor.getPassword());
			ps.setDouble(5, donor.getDonorId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean remove(int donorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "Delete from donordetails where Donor_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, donorId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static DonorDetails find(int donorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		DonorDetails donor = new DonorDetails();
		try {
			String sql = "select * from donordetails where Donor_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				donor.setDonorId(rs.getInt(1));
				donor.setName(rs.getString(2));
				donor.setContactNumber(rs.getString(3));
				donor.setEmail(rs.getString(4));
				donor.setPassword(rs.getString(5));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return donor;
	}
	

	public static ArrayList<DonorDetails> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<DonorDetails> listdonor = new ArrayList<DonorDetails>();
		try {
			String sql = "select * from donordetails";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DonorDetails donor = new DonorDetails();
				donor.setDonorId(rs.getInt(1));
				donor.setName(rs.getString(2));
				donor.setContactNumber(rs.getString(3));
				donor.setEmail(rs.getString(4));
				donor.setPassword(rs.getString(5));
				listdonor.add(donor);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listdonor;
	}
	
	public static int validate(String email,String password) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select Donor_Id from donordetails where Email = ? and Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				id = rs.getInt("Donor_Id");
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}	
		return id;
	}
	
	public static int donationCount(int donorId) {
		int count = 0;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select count(*) from donation where Donor_Id = ? and status='yes'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donorId);
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
	
	public static boolean checkPassword(String password, int donorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		String pass = new String();
		try {
			String sql = "select Password from donordetails where Donor_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donorId);
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
	
	
	public static void changeDonorPassword(String password, int donorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update donordetails set Password=? where Donor_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, donorId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public static void main(String args[]) {

//		 DonorDetails donor = new DonorDetails("afafafdf", "3653278562", "safhjh@gmaIL.com", "sdfsdfs");
//	 	 DonorDetailsDao donordetailsDao = new DonorDetailsDao();
//		 donordetailsDao.create(donor);

//		 DonorDetails donor = new DonorDetails(1002, "dfhdfhdfh", "46446456" , "fffggg@gmaIL.com", "fffffffffffff");
//		 DonorDetailsDao donordetailsDao = new DonorDetailsDao();
//		 donordetailsDao.edit(donor);
		
//		System.out.println(DonorDetailsDao.donationCount(1003));

//		 DonorDetailsDao donordetailsDao = new DonorDetailsDao();
//		 DonorDetails donor = donordetailsDao.find(1002);
//		 System.out.println(donor);

//		 DonorDetailsDao donordetailsDao = new DonorDetailsDao();
//		 ArrayList<DonorDetails> al = donordetailsDao.findAll();
//		 for (DonorDetails donor : al)
//		 System.out.println(donor);

//		 DonorDetails donor = new DonorDetails(1002, "daredevil");
//		 DonorDetailsDao donordetailsDao = new DonorDetailsDao();
//		 donordetailsDao.changeDonorPassword(donor);

//		 DonorDetailsDao donordetailsDao = new DonorDetailsDao();
//		 donordetailsDao.remove(1002);

	}

}
