package com.umeed.pojos;

import java.io.Serializable;

public class Location implements Serializable {

	private int locationId;
	private String address;

	public Location() {
		super();
	}

	public Location(String address) {
		super();
		this.address = address;
	}

	public Location(int locationId, String address) {
		this.locationId = locationId;
		this.address = address;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId 
				+ ", address=" + address + "]";
	}

}
