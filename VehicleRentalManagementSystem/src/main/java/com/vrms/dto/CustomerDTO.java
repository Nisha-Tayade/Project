package com.vrms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDTO {
	

	private int customerId;
	
	@NotBlank
	@Size(min=3, max=15, message="Please enter valid FirstName.")
	private String firstName;
	
	@NotBlank
	@Size(min=3, max=15, message="Please enter valid LastName.")
	private String lastName;
	
	private long mobileNumber;
	
	@NotBlank
	@Email(message = "Please enter valid Email.")
	private String emailId;
	
	@NotBlank
	private String address;

	public CustomerDTO() {}
	
	public CustomerDTO(@NotNull @Size(min = 1, max = 3, message = "Please enter valid CustomerId.") int customerId,
			@NotBlank @Size(min = 3, max = 15, message = "Please enter valid FirstName.") String firstName,
			@NotBlank @Size(min = 3, max = 15, message = "Please enter valid LastName.") String lastName,
			@NotNull @Size(min = 10, message = "Please enter valid Mobile Number.") long mobileNumber,
			@NotBlank @Email(message = "Please enter valid Email.") String emailId, @NotBlank String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
