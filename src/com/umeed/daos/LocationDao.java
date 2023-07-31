package com.umeed.daos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.umeed.utilities.*;
import com.umeed.pojos.*;

public class LocationDao {

	public static boolean create(Location location) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "insert into location (Location_Id, Address) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, location.getLocationId());
			ps.setString(2, location.getAddress());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean edit(Location location) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "update location set Address=? where Location_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, location.getAddress());
			ps.setInt(2, location.getLocationId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean remove(int locationId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "Delete from location where Location_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, locationId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static Location find(int locationId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Location location = new Location();
		try {
			String sql = "select * from location where Location_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, locationId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				location.setLocationId(rs.getInt(1));
				location.setAddress(rs.getString(2));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return location;
	}

	public ArrayList<Location> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Location> listlocation = new ArrayList<Location>();
		try {
			String sql = "select * from location";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Location location = new Location();
				location.setLocationId(rs.getInt(1));
				location.setAddress(rs.getString(2));
				listlocation.add(location);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listlocation;
	}
	
	public static int getId(String location) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int locId = -1;
		try {
			String sql = "select Location_Id from location where Address = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				locId=rs.getInt(1);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return locId;
	}

	public static void main(String args[]) {
		
//		java.util.Date date = new java.util.Date();
//		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
//		String dt = df.format(date);
//		System.out.println(dt);
		
//		 Location location = new Location("safaf");
//		 LocationDao locationDao = new LocationDao();
//		 locationDao.create(location);
		
//		 Location location = new Location(4658, "ShantiTirth");
//		 LocationDao locationDao = new LocationDao();
//		 locationDao.edit(location);

//		 LocationDao locationDao = new LocationDao();
//		 Location location = locationDao.find(4658);
//		 System.out.println(location);

//		 LocationDao locationDao = new LocationDao();
//		 ArrayList<Location> al = locationDao.findAll();
//		 for (Location location : al)
//		 System.out.println(location);

//		 LocationDao locationDao = new LocationDao();
//		 locationDao.remove(4659);


	}
}


