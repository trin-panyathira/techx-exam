package com.techx.bookstore.model;

public class BookModel {
	private int id;
	private String name;
	private String author;
	private double price;
	private boolean is_recommended;
	
	
	public BookModel(int id, String name, String author, double price, boolean is_recommended) {
//		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.is_recommended = is_recommended;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isIs_recommended() {
		return is_recommended;
	}
	public void setIs_recommended(boolean is_recommended) {
		this.is_recommended = is_recommended;
	}
	
	
}
