package com.techx.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techx.bookstore.Database.BookOrder;
import com.techx.bookstore.Database.BookOrderPK;
import com.techx.bookstore.model.BookModel;
import com.techx.bookstore.model.OrderModel;
import com.techx.bookstore.repository.interfaces.IBookRepo;
import com.techx.bookstore.service.interfaces.IBookService;

@Service
public class BookService implements IBookService {
	
	private IBookRepo bookRepo;
	
	public BookService(IBookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<BookModel> getBook() {
		var result = new ArrayList<BookModel>();

		var listDB = bookRepo.getBook();
		
		// Convert Model
		for(var i : listDB)
		{
			var item = new BookModel(i.getId(), i.getName(), i.getAuthor(), i.getPrice(), i.isRecommended());
			result.add(item);
		}
		
		return result;
	}
	
	public double createOrder(int userId, List<Integer> orders) {
		double totalPrice = 0;
		var bookListDb = bookRepo.getBookByIds(orders);

		// Create Model
		var bookOrders = new ArrayList<BookOrder>();
		for(var book : bookListDb)
		{
			int qty = 1;
			var bookOrderpk = new BookOrderPK(userId, book.getId());
			var item = new BookOrder(bookOrderpk, qty);
			bookOrders.add(item);
			
			totalPrice += (book.getPrice() * qty);
		}
		
		var orderListDB = bookRepo.add(bookOrders);
		
		return totalPrice;
	}
	
	public int deleteOrderByUserId(int userId) {
		var orderListDB = bookRepo.getOrderBookByUserId(userId);
		var deleteResult = bookRepo.delete(orderListDB);
		
		int result = orderListDB.size();
		
		return result;
	}
	
}
