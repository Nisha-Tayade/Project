package com.vrms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdminDTO {
	
	@NotNull
	private int adminId;
	
	@NotBlank
	@Size(min=5, max=15, message="Enter valid username.")
	private String username;
	
	@NotBlank
	@Size(min=8,max=15, message="Enter valid username.")
	private String password;

	public AdminDTO() {}

	public AdminDTO(@NotNull int adminId, @NotBlank @Size(min = 5, max = 15, message = "Enter valid username.") String username,
			@NotBlank @Size(min = 8, max = 15, message = "Enter valid username.") String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
