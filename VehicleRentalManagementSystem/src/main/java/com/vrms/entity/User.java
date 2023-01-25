package com.vrms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User_Table")
public class User {

	@Id
	@SequenceGenerator(name="cId_SEQ",initialValue = 51)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cId_SEQ")
	private int userId;
	private String password;
	private String role;
	
	public boolean checkAdmin() {
		return (getRole().equals("admin"));
	}
	
		public boolean checkCustomer() {
			return (getRole().equals("customer"));
		}
	public User() {}
	
	public User(int userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
}
