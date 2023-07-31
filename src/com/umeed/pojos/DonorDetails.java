package com.umeed.pojos;

import java.io.Serializable;

public class DonorDetails implements Serializable {

	private int donorId;
	private String name;
	private String contactNumber;
	private String email;
	private String password;

	public DonorDetails() {
		super();
	}

	public DonorDetails(int donorId, String password) {
		super();
		this.donorId = donorId;
		this.password = password;
	}

	public DonorDetails(String name, String contactNumber, String email, String password) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}

	public DonorDetails(int donorId, String name, String contactNumber, String email, String password) {
		this.donorId = donorId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DonorDetails [donorId=" + donorId + ", name=" + name + ", contactNumber=" + contactNumber + ", email="
				+ email + ", password=" + password + "]";
	}

}
