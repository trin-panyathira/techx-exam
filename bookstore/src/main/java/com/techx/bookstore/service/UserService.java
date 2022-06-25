package com.techx.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techx.bookstore.Database.User;
import com.techx.bookstore.Utility.Utility;
import com.techx.bookstore.exception.CustomeException;
import com.techx.bookstore.model.BookModel;
import com.techx.bookstore.model.UserRequestModel;
import com.techx.bookstore.model.UserRespondModel;
import com.techx.bookstore.repository.interfaces.IBookRepo;
import com.techx.bookstore.repository.interfaces.IUserRepo;
import com.techx.bookstore.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	
	private IUserRepo userRepo;
	private IBookRepo bookRepo;
	
	public UserService(IUserRepo userRepo, IBookRepo bookRepo) {
		this.userRepo = userRepo;
		this.bookRepo = bookRepo;
	}
	
	public UserRespondModel login(String username, String password) {
		UserRespondModel result = null;
		
		var dataDB = userRepo.getUser(username);
		
		if(dataDB == null)
			throw new CustomeException("This Username is not exist.");
		
		String passwordHash = Utility.SHA256Hash(password);
		if(!dataDB.getPassword().equals(passwordHash))
			throw new CustomeException("Password incorrect.");
		
		// Set Result
		result = new UserRespondModel(dataDB.getUsername(), dataDB.getName(), dataDB.getSurname(), dataDB.getDateOfBirth(), new ArrayList<Integer>());
		
		return result;
	}
	
	public UserRespondModel getUser(String username) {
		var result = new UserRespondModel();
		
		var dataDB = userRepo.getUser(username);
		
		// Convert Model
		if(dataDB != null)
		{
			// Get Book List
			var bookListDB = bookRepo.getOrderBookByUserId(dataDB.getId());
			var books = new ArrayList<Integer>();
			for(var book : bookListDB)
				books.add(book.getBookOrderPK().getBookId());
			
			// Set Result
			result = new UserRespondModel(dataDB.getUsername(), dataDB.getName(), dataDB.getSurname(), dataDB.getDateOfBirth(), books);
		}
		
		return result;
	}
	
	public int getUserId(String username) {
		int result = -1;
		
		var dataDB = userRepo.getUser(username);
		
		// Convert Model
		if(dataDB != null)
		{
			result = dataDB.getId();
		}
		
		return result;
	}
	
	public boolean createUser(UserRequestModel data) {
		
		var dataDB = userRepo.getUser(data.getUsername());
		// Convert Model
		if(dataDB != null)
		{
			throw new CustomeException("This username's already exist.");
		}
		
		String passwordHash = Utility.SHA256Hash(data.getPassword());
		var newData = new User(data.getUsername(), passwordHash, data.getName(), data.getSurname(), data.getDate_of_birth());
		var insertResult = userRepo.add(newData);
		var result = newData.getId();
		
		return insertResult;
	}
	
	public int deleteUser(String username) {
		var userDB = userRepo.getUser(username);
		var deleteResult = userRepo.delete(userDB);
		var result = userDB.getId();
		
		return result;
	}
	
}
