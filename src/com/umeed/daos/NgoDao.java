package com.umeed.daos;

import java.sql.*;
import java.util.*;
import com.umeed.utilities.*;
import com.umeed.pojos.*;


public class NgoDao {

	public boolean create(Ngo ngo) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "insert into ngodetails (Name,Contact_Number,Email,Address,Owner_Name,Owner_Number,Owner_Email,Password) values (?,?,?,?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ngo.getName());
			ps.setString(2, ngo.getContactNumber());
			ps.setString(3, ngo.getEmail());
			ps.setString(4, ngo.getAddress());
			ps.setString(5, ngo.getOwnerName());
			ps.setString(6, ngo.getOwnerNumber());
			ps.setString(7, ngo.getOwnerEmail());
			ps.setString(8, ngo.getPassword());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean edit(Ngo ngo) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "update ngodetails set Name=? ,Contact_Number=?,Email=?,Address=?,Owner_Name=?,Owner_Number=?,Owner_Email=?, Password = ? where ngo_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ngo.getName());
			ps.setString(2, ngo.getContactNumber());
			ps.setString(3, ngo.getEmail());
			ps.setString(4, ngo.getAddress());
			ps.setString(5, ngo.getOwnerName());
			ps.setString(6, ngo.getOwnerNumber());
			ps.setString(7, ngo.getOwnerEmail());
			ps.setString(8, ngo.getPassword());
			ps.setDouble(9, ngo.getNgoId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean remove(int ngoId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "Delete from ngodetails where NGO_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, ngoId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static Ngo find(int ngoId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Ngo ngo = new Ngo();
		try {
			String sql = "select * from ngodetails where NGO_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ngoId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ngo.setNgoId(rs.getInt(1));
				ngo.setName(rs.getString(2));
				ngo.setContactNumber(rs.getString(3));
				ngo.setEmail(rs.getString(4));
				ngo.setAddress(rs.getString(5));
				ngo.setOwnerName(rs.getString(6));
				ngo.setOwnerNumber(rs.getString(7));
				ngo.setOwnerEmail(rs.getString(8));
				ngo.setPassword(rs.getString(9));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return ngo;
	}

	public static ArrayList<Ngo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Ngo> listngo = new ArrayList<Ngo>();
		try {
			String sql = "select * from ngodetails";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ngo ngo = new Ngo();
				ngo.setNgoId(rs.getInt(1));
				ngo.setName(rs.getString(2));
				ngo.setContactNumber(rs.getString(3));
				ngo.setEmail(rs.getString(4));
				ngo.setAddress(rs.getString(5));
				ngo.setOwnerName(rs.getString(6));
				ngo.setOwnerNumber(rs.getString(7));
				ngo.setOwnerEmail(rs.getString(8));
				ngo.setPassword(rs.getString(9));
				listngo.add(ngo);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listngo;
	}
	
	public static int validate(String email,String password) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select NGO_Id from ngodetails where Email = ? and Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				id = rs.getInt("NGO_Id");
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}	
		return id;
	}

	public static void changeNgoPassword(String password, int ngoId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update ngodetails set password=? where NGO_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, ngoId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public static boolean checkPassword(String password, int ngoId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		String pass = new String();
		try {
			String sql = "select Password from ngodetails where NGO_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ngoId);
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
	
	public static int donationReceived(int ngoId) {
		int count = 0;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select count(*) from donation where NGO_Id = ? and status='yes'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ngoId);
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
		
	System.out.println("Hello");
//		 Ngo ngo = new Ngo( "muskanf", "3653278562" , "safhjh@gmaIL.com", "sdfsdfs", "chachu","ergerghe","sdgsdg","dsgdsg");
//		 NgoDao ngoDao = new NgoDao();
//		 ngoDao.create(ngo);

//		 Ngo ngo = new Ngo(3002, "msdgsdgd", "46446456" , "dfhdfhd@gmaIL.co", "sdfsdfs", "sdgsdg", "fgegdsds", "dfhdfhd", "sdgsh");
//		 NgoDao NgoDao = new NgoDao();
//		 NgoDao.edit(ngo);

//		 NgoDao ngoDao = new NgoDao();
//		 Ngo ngo = ngoDao.find(3002);
//		 System.out.println(ngo);

//		 NgoDao NgoDao = new NgoDao();
//		 ArrayList<Ngo> al = NgoDao.findAll();
//		 for (Ngo ngo : al)
//		 System.out.println(ngo);

//		 Ngo ngo = new Ngo(3002, "daredevil");
//		 NgoDao ngoDao = new NgoDao();
//		 ngoDao.changeNgoPassword(ngo);

//		 NgoDao NgoDao = new NgoDao();
//		 NgoDao.remove(3002);

	}
}
