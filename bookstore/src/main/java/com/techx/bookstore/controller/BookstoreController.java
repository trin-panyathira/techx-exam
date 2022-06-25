package com.techx.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techx.bookstore.exception.CustomeException;
import com.techx.bookstore.model.BookModel;
import com.techx.bookstore.model.LoginModel;
import com.techx.bookstore.model.OrderModel;
import com.techx.bookstore.model.UserRequestModel;
import com.techx.bookstore.model.UserRespondModel;
import com.techx.bookstore.service.interfaces.IBookService;
import com.techx.bookstore.service.interfaces.IUserService;


@RestController
@RequestMapping("/api")
public class BookstoreController {
	
	// simple save user
	private static String username = null;

	private IUserService userService;
	private IBookService bookService;
	
	public BookstoreController(IUserService userService, IBookService bookService) {
		this.userService = userService;
		this.bookService = bookService;
	}

	// GET : http://localhost:9090/swagger-ui/index.html
	
	@PostMapping("/login")
	public ResponseEntity postLogin(@RequestBody LoginModel data) {
		// Simple Reset User
		this.username = null;
		
		var user = userService.login(data.getUsername(), data.getPassword());

		if(user != null)
			username = user.getUsername();
			
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	@GetMapping("/user")
	public ResponseEntity<UserRespondModel> getUser() {
		// Check User
		if(this.username == null)
			throw new CustomeException("Please login.");
		
		// Simple Set User
		String username = this.username;
		
		
		var result = userService.getUser(username);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity deleteUser() {
		// Check User
		if(this.username == null)
			throw new CustomeException("Please login.");

		// Simple Set User
		String username = this.username;
			
		
		
		var userId = userService.deleteUser(username);
		var resultOrder = bookService.deleteOrderByUserId(userId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	@PostMapping("/user")
	public ResponseEntity postUser(@RequestBody UserRequestModel data) {
		var result = userService.createUser(data);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	@PostMapping("/users/orders")
	public ResponseEntity<Double> postUserOrder(@RequestBody OrderModel data) {
		// Check User
		if(this.username == null)
			throw new CustomeException("Please login.");

		// Simple Set User
		String username = this.username;
		
		
		
		double result = 0;
		
		var orders = data.getOrders();
		// validate input size
		if(orders == null || orders.size() == 0)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		
		var userId = userService.getUserId(username);
		if(userId != -1)
		{
			var resultOrder = bookService.deleteOrderByUserId(userId);
			result = bookService.createOrder(userId, orders);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<BookModel>> getBook() {
		var result = bookService.getBook();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}
}
