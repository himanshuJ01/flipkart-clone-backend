package com.flipkartclone.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customerData")
public class Customer {
	//private variables
	
	@Id
	private int customerId;
	private String fullName;
	private String email;
	private Long mobileNumber;
	private String gender;
	private String password;
	private Address address;
	
	//default constructors
	Customer() {
		super();
	}
	
	//parameterize constructor
	public Customer(int customerId, String fullName, String email, Long mobileNumber, String gender, String password,
			Address address) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.password = password;
		this.address = address;
	}
	
	//getter and setter
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", gender=" + gender + ", password=" + password + ", address=" + address + "]";
	}

		

}