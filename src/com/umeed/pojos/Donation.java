package com.umeed.pojos;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Donation implements Serializable {

	private int donationId;
	private String donationType;
	private Date dateTime;
	private int ngoId;
	private int donorId;
	private int volunteerId;
	private int locationId;
	private String status;
	private Date deliveryDate;
	
	public Donation() {
		super();
	}

	public Donation(String donationType, Date dateTime, int ngoId, int donorId, int volunteerId, int locationId, String status) {
		super();
		this.donationType = donationType;
		this.dateTime = dateTime;
		this.ngoId = ngoId;
		this.donorId = donorId;
		this.volunteerId = volunteerId;
		this.locationId = locationId;
		this.status = status;
	}

	public Donation(int donationId, String donationType, Date dateTime, int ngoId, int donorId, int volunteerId, int locationid, String status) {
		this.donationId = donationId;
		this.donationType = donationType;
		this.dateTime = dateTime;
		this.ngoId = ngoId;
		this.donorId = donorId;
		this.volunteerId = volunteerId;
		this.locationId = locationid;
		this.status = status;
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getNgoId() {
		return ngoId;
	}

	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationid) {
		this.locationId = locationid;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donationType=" + donationType + ", dateTime=" + dateTime
				+ ", ngoId=" + ngoId + ", donorId=" + donorId + ", volunteerId=" + volunteerId + ", locationId="
				+ locationId + ", status=" + status + ", delivery_date=" + deliveryDate +"]";
	}

}
