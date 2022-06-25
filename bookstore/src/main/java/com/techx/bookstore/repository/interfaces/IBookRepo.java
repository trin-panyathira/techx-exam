package com.techx.bookstore.repository.interfaces;

import java.util.List;

import com.techx.bookstore.Database.Book;
import com.techx.bookstore.Database.BookOrder;
import com.techx.bookstore.Database.User;

public interface IBookRepo {
	List<Book> getBook();
	List<Book> getBookByIds(List<Integer> ids);
	List<BookOrder> getOrderBookByUserId(int userId);
	
	
	
	boolean add(BookOrder data);
	boolean add(List<BookOrder> data);
	boolean delete(BookOrder data);
	boolean delete(List<BookOrder> data);
}
