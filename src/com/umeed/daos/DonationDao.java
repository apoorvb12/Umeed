package com.umeed.daos;

import java.sql.*;
import java.util.*;
import com.umeed.utilities.*;
import com.umeed.pojos.*;

public class DonationDao {

	public boolean create(Donation donation) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "insert into donation (Donation_Type,DateTime,Ngo_Id,Donor_Id,Volunteer_Id,Location_Id,status)values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, donation.getDonationType());
			java.sql.Timestamp dt = new java.sql.Timestamp(donation.getDateTime().getTime());
			ps.setTimestamp(2, dt);
			ps.setInt(3, donation.getNgoId());
			ps.setInt(4, donation.getDonorId());
			ps.setInt(5, donation.getVolunteerId());
			ps.setInt(6, donation.getLocationId());
			ps.setString(7, donation.getStatus());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static boolean edit(Donation donation) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "update donation set Donation_Type=? ,DateTime=?,NGO_Id=?,Donor_Id=?,Volunteer_Id=?,Location_Id=?,status=?,delivery_date=? where Donation_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, donation.getDonationType());
			java.sql.Timestamp dt = new java.sql.Timestamp(donation.getDateTime().getTime());
			ps.setTimestamp(2, dt);
			ps.setInt(3, donation.getNgoId());
			ps.setInt(4, donation.getDonorId());
			ps.setInt(5, donation.getVolunteerId());
			ps.setInt(6, donation.getLocationId());
			ps.setString(7, donation.getStatus());
			java.sql.Timestamp date = new java.sql.Timestamp(donation.getDeliveryDate().getTime());
			ps.setTimestamp(8, date);
			ps.setInt(9, donation.getDonationId());
			ps.executeUpdate();
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public boolean remove(int donationId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean result = true;
		try {
			String sql = "delete from donation where Donation_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donationId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			result = false;
		} finally {
			pool.putConnection(conn);
		}
		return result;
	}

	public static Donation find(int donationId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Donation donation = new Donation();
		try {
			String sql = "select * from donation where Donation_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donationId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				donation.setDonationId(donationId);
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				System.out.println("new"+dt.toString());
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				try {
					donation.setDeliveryDate(new java.util.Date(date.getTime()));
					}catch(NullPointerException npe) {
						System.out.println("Delivery Date is Null");
					}
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return donation;
	}

	public static ArrayList<Donation> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				try {
					donation.setDeliveryDate(new java.util.Date(date.getTime()));
					}catch(NullPointerException npe) {
						System.out.println("Delivery Date is Null");
					}
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByStatusNo(int donorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='no' and Donor_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);try {
				donation.setDeliveryDate(new java.util.Date(date.getTime()));
				}catch(NullPointerException npe) {
					System.out.println("Delivery Date is Null");
				}
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByStatusYes(int donorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='yes' and Donor_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, donorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				donation.setDeliveryDate(new java.util.Date(date.getTime()));
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByYes() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='yes'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				donation.setDeliveryDate(new java.util.Date(date.getTime()));
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByNo() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='no'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				try {
					donation.setDeliveryDate(new java.util.Date(date.getTime()));
					}catch(NullPointerException npe) {
						System.out.println("Delivery Date is Null");
					}
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByNgoStatusYes(int ngoId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='yes' and NGO_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ngoId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				donation.setDeliveryDate(new java.util.Date(date.getTime()));
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByNgoStatusNo(int ngoId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='no' and NGO_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ngoId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				try {
					donation.setDeliveryDate(new java.util.Date(date.getTime()));
					}catch(NullPointerException npe) {
						System.out.println("Delivery Date is Null");
					}
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByVolunteerStatusNo(int volunteerId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='no' and Volunteer_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);try {
				donation.setDeliveryDate(new java.util.Date(date.getTime()));
				}catch(NullPointerException npe) {
					System.out.println("Delivery Date is Null");
				}
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}
	
	public static ArrayList<Donation> findAllByVolunteerStatusYes(int volunteerId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Donation> listDonation = new ArrayList<Donation>();
		try {
			String sql = "select * from donation where status='yes' and Volunteer_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setDonationType(rs.getString(2));
				java.sql.Timestamp dt = rs.getTimestamp(3);
				donation.setDateTime(new java.util.Date(dt.getTime()));
				donation.setNgoId(rs.getInt(4));
				donation.setDonorId(rs.getInt(5));
				donation.setVolunteerId(rs.getInt(6));
				donation.setLocationId(rs.getInt(7));
				donation.setStatus(rs.getString(8));
				java.sql.Timestamp date = rs.getTimestamp(9);
				donation.setDeliveryDate(new java.util.Date(date.getTime()));
				listDonation.add(donation);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listDonation;
	}

	public static void main(String args[]) {
//		java.util.Date dt = Dates.convertDate("10-1-1999 10:10:15");
//		Donation donation = new Donation("dgjksdgb",dt,3000,1000,2000,4657);
//		DonationDao donationDao = new DonationDao();
//		donationDao.create(donation);

//		java.util.Date dt = Dates.convertDate("10-1-1999 10:10:15");
//		Donation donation = new Donation(4001,"dfhsfhksd",dt,3000,1000,2000,4657);
//		DonationDao donationDao = new DonationDao();
//		donationDao.edit(donation);

//        Donation donation = DonationDao.find(7001);
//		System.out.println(donation);

//		 DonationDao donationDao = new DonationDao();
//		 ArrayList<Donation> al = donationDao.findAll();
//		 for (Donation donation : al)
//		 System.out.println(donation);

//		 DonationDao donationDao = new DonationDao();
//		 donationDao.remove(7000);

	}
}
