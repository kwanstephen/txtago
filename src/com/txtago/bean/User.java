package com.txtago.bean;

import java.io.Serializable;


public class User implements Serializable{

	
	private String password;
	private String role = "TXG_USER";
	private int loginCode;
	private int id;
	private boolean loggedIn;
	
	private String status = "ACTIVE";
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername()
	{
		return email;
	}
	
	public void setUsername(String name)
	{
		email = name;
	}
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String lastName;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
	
	public String getPassword() {
		return password;
	}
		
	public int getLoginCode() {
		return loginCode;
	}
		
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public void setLoginCode(int loginCode) {
		this.loginCode = loginCode;
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
}
