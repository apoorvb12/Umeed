package com.umeed.daos;

import java.sql.*;
import java.util.*;
import com.umeed.utilities.*;
import com.umeed.pojos.*;

public class AdminDao {

	public boolean create(Admin admin) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "insert into admin (Admin_Id, Email, Password) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, admin.getAdminId());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static boolean edit(Admin admin) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "update admin set Email=? ,Password=? where Admin_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getEmail());
			ps.setString(2, admin.getPassword());
			ps.setDouble(3, admin.getAdminId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean remove(int AdminId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean result = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "Delete from admin where Admin_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, AdminId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static Admin find(int AdminId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Admin admin = new Admin();
		try {
			String sql = "select * from admin where Admin_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, AdminId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin.setAdminId(rs.getInt(1));
				admin.setEmail(rs.getString(2));
				admin.setPassword(rs.getString(3));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return admin;
	}

	public ArrayList<Admin> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Admin> listadmin = new ArrayList<Admin>();
		try {
			String sql = "select * from admin";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setEmail(rs.getString(2));
				admin.setPassword(rs.getString(3));
				listadmin.add(admin);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listadmin;
	}
	
	public static int validate(String email,String password) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select Admin_id from admin where Email = ? and Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				id = rs.getInt("Admin_id");
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}	
		return id;
	}

	public void changeAdminPassword(Admin admin) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update admin set Password=? where Admin_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getPassword());
			ps.setDouble(2, admin.getAdminId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public static void main(String args[]) {
		
		
//		 Admin admin = new Admin( "adkad@gmail.com" , "hsfljhf");
//		 AdminDao adminDao = new AdminDao();
//		 adminDao.create(admin);

//		 Admin admin = new Admin( 2, "afafsdsdmail", "adsvsdvkad");
//		 AdminDao adminDao = new AdminDao();
//		 adminDao.edit(admin);

//		 AdminDao adminDao = new AdminDao();
//		 Admin admin = adminDao.find(2);

//		 AdminDao adminDao = new AdminDao();
//		 ArrayList<Admin> al = adminDao.findAll();
//		 for (Admin admin : al)
//		 System.out.println(admin);


//		 Admin admin = new Admin(2, "daredevil");
//		 AdminDao adminDao = new AdminDao();
//		 adminDao.changeAdminPassword(admin);

//		 AdminDao adminDao = new AdminDao();
//		 adminDao.remove(2);

	}
}
