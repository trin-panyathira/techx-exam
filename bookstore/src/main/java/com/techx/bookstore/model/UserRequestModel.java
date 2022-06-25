package com.techx.bookstore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequestModel {
	private String username;
	private String password;
	private String name;
	private String surname;
	private String date_of_birth;
	
	public UserRequestModel() {}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	
	
}
