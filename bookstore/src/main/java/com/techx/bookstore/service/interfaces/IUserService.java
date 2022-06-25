package com.techx.bookstore.service.interfaces;

import java.util.List;

import com.techx.bookstore.model.UserRequestModel;
import com.techx.bookstore.model.UserRespondModel;

public interface IUserService {
	UserRespondModel login(String username, String password);
	UserRespondModel getUser(String username);
	int getUserId(String username);
	boolean createUser(UserRequestModel data);
	int deleteUser(String username);
}
