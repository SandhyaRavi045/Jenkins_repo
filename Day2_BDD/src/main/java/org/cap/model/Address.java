package org.cap.model;

public class Address {
	
	private String doorNo;
	private String city;
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(String doorNo, String city) {
		super();
		this.doorNo = doorNo;
		this.city = city;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", city=" + city + "]";
	}
	
	

}
