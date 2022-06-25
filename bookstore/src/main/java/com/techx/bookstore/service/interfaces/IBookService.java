package com.techx.bookstore.service.interfaces;

import java.util.List;

import com.techx.bookstore.model.BookModel;
import com.techx.bookstore.model.OrderModel;

public interface IBookService {
	List<BookModel> getBook();
	double createOrder(int userId, List<Integer> orders);
	int deleteOrderByUserId(int userId);
}
