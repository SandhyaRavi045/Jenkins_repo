package org.cap.model;

import java.util.List;

public class Customer {
	
	private String firstName;
	private String lastName;
	private Address address;
	private List<Account> accounts;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer(String firstName, String lastName, Address address, List<Account> accounts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.accounts = accounts;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", accounts="
				+ accounts + "]";
	}
	

}
