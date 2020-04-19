package com.lockedme.model;

public class User {

	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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


	public User(String username, String password) {
		super();
		this.userName=username;
		this.password=password;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstName + ", LastName=" + lastName+"]";
	}
	
}