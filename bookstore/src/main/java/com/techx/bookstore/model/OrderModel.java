package com.techx.bookstore.model;

import java.util.List;

public class OrderModel {
	private List<Integer> orders;

	public OrderModel() {}
	public OrderModel(List<Integer> orders) {
		super();
		this.orders = orders;
	}

	public List<Integer> getOrders() {
		return orders;
	}

	public void setOrders(List<Integer> orders) {
		this.orders = orders;
	}
}
