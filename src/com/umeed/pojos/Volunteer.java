package com.umeed.pojos;

import java.io.Serializable;

public class Volunteer implements Serializable {

	private int volunteerId;
	private String name;
	private String contactNumber;
	private String email;
	private String password;
	private String area;
	private String city;



	public Volunteer() {
		super();
	}

	public Volunteer(int volunteerId, String password) {
		super();
		this.volunteerId = volunteerId;
		this.password = password;
	}

	public Volunteer(String name, String contactNumber, String email, String password, String area, String city) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.area = area;
		this.city = city;
	}

	public Volunteer(int volunteerId, String name, String contactNumber, String email, String password, String area, String city) {
		this.volunteerId = volunteerId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.area = area;
		this.city = city;
	}

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Volunteer [volunteerId=" + volunteerId + ", name=" + name + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", password=" + password + ", area=" + area + "city=" + city + "]";
	}

}
