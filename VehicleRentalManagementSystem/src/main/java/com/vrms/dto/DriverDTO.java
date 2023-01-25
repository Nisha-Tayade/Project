package com.vrms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DriverDTO {
	
	@NotNull
	@Size(min=3, max=10, message="Please enter valid Driver ID.")
	private int driverId;
	
	@NotBlank
	@Size(min=5, max=15, message="Please enter valid first name.")
	private String firstName;
	
	@NotBlank
	@Size(min=5, max=15, message="Please enter valid last name.")
	private String lastName;
	
	@NotNull
	private long contactNumber;
	
	@NotNull
	@Email(message="Please enter valid Email id.")
	private String email;
	
	@NotBlank
	private String address;
	
	@NotNull
	private double chargesPerDay;
	
	@NotBlank
	private String licenseNo;

	public DriverDTO() {}
	
	public DriverDTO(@NotNull @Size(min = 3, max = 10, message = "Please enter valid Driver ID.") int driverId,
			@NotBlank @Size(min = 5, max = 15, message = "Please enter valid first name.") String firstName,
			@NotBlank @Size(min = 5, max = 15, message = "Please enter valid last name.") String lastName,
			@NotBlank long contactNumber, @NotNull @Email(message = "Please enter valid Email id.") String email,
			@NotBlank String address, @NotNull double chargesPerDay, @NotBlank String licenseNo) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

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

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
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

	public double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
