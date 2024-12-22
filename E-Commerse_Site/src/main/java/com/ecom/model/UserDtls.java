package com.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String mobileNumber;
	
	private String email;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String password;
	
	private String profleImage;
	
	private String role;
	
	private boolean isEnable;
	
	

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfleImage() {
		return profleImage;
	}

	public void setProfleImage(String profleImage) {
		this.profleImage = profleImage;
	}

	
	
	@Override
	public String toString() {
		return "UserDtls [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", password=" + password + ", profleImage=" + profleImage + ", role=" + role + ", isEnable="
				+ isEnable + "]";
	}
	

	public UserDtls(int id, String name, String mobileNumber, String email, String address, String city, String state,
			String pincode, String password, String profleImage, String role, boolean isEnable) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.password = password;
		this.profleImage = profleImage;
		this.role = role;
		this.isEnable = isEnable;
	}

	public UserDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
