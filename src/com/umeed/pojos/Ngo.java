package com.umeed.pojos;

import java.io.Serializable;

public class Ngo implements Serializable {

	private int ngoId;
	private String name;
	private String contactNumber;
	private String email;
	private String address;
	private String ownerName;
	private String ownerNumber;
	private String ownerEmail;
	private String password;

	public Ngo() {
		super();
	}

	public Ngo(int ngoId, String password) {
		super();
		this.ngoId = ngoId;
		this.password = password;
	}

	public Ngo(String name, String contactNumber, String email, String address, String ownerName, String ownerNumber,
			String ownerEmail, String password) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.ownerName = ownerName;
		this.ownerNumber = ownerNumber;
		this.ownerEmail = ownerEmail;
		this.password = password;
	}

	public Ngo(int ngoId, String name, String contactNumber, String email, String address, String ownerName,
			String ownerNumber, String ownerEmail, String password) {
		this.ngoId = ngoId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.ownerName = ownerName;
		this.ownerNumber = ownerNumber;
		this.ownerEmail = ownerEmail;
		this.password = password;
	}

	public int getNgoId() {
		return ngoId;
	}

	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerNumber() {
		return ownerNumber;
	}

	public void setOwnerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Ngo [ngoId=" + ngoId + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", address=" + address + ", ownerName=" + ownerName + ", ownerNumber=" + ownerNumber + ", ownerEmail="
				+ ownerEmail + ", password=" + password + "]";
	}

}
