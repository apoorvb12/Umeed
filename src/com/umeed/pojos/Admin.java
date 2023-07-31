package com.umeed.pojos;

import java.io.Serializable;

public class Admin implements Serializable {

	private String password;
	private String email;
	private double adminId;

	public Admin() {
		super();
	}

	public Admin(double adminId, String password) {
		super();
		this.password = password;
		this.adminId = adminId;
	}

	public Admin(double adminId, String password, String email) {
		this.password = password;
		this.email = email;
		this.adminId = adminId;
	}

	public Admin(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public double getAdminId() {
		return adminId;
	}

	public void setAdminId(double adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [password=" + password + ", email=" + email + ", adminId=" + adminId + "]";
	}

}
