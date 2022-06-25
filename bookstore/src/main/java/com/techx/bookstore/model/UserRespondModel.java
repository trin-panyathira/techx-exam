package com.techx.bookstore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRespondModel {
	private String username;
	private String name;
	private String surname;
	private String date_of_birth;
	private List<Integer> books;
	
	public UserRespondModel() {}
	public UserRespondModel(String username, String name, String surname, String date_of_birth, List<Integer> books) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.books = books;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public List<Integer> getBooks() {
		return books;
	}
	public void setBooks(List<Integer> books) {
		this.books = books;
	}
	
}
