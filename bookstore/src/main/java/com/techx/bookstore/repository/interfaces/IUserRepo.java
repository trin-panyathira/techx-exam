package com.techx.bookstore.repository.interfaces;

import java.util.List;

import com.techx.bookstore.Database.User;

public interface IUserRepo {
	User getUser(String username);
	
	
	
	boolean add(User data);
	boolean add(List<User> data);
	boolean delete(User data);
	boolean delete(List<User> data);
}
