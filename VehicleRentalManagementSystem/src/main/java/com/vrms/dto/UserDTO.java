package com.vrms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

//	@NotNull
//	@Min(value = 3, message = "Please enter valid User ID.")
	private int userId;

	@NotBlank
	@Size(min = 8, max = 15, message = "Please enter valid Password.")
	private String password;

	@NotBlank(message = "Role is needed")
	private String role;

	public UserDTO() {
 }
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
