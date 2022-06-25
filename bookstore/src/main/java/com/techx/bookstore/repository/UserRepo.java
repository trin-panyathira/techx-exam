package com.techx.bookstore.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.techx.bookstore.Database.Book;
import com.techx.bookstore.Database.User;
import com.techx.bookstore.model.BookModel;
import com.techx.bookstore.repository.interfaces.IUserRepo;

@Repository
public class UserRepo implements IUserRepo {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
	private EntityManager entityManager = emf.createEntityManager();
	
	public User getUser(String username) {
		var preQuery = entityManager.createQuery("SELECT a from User a WHERE a.username = ?1", User.class);
		var query = preQuery.setParameter(1, username);
		var result = query.getResultList().stream().findFirst().orElse(null); // select firstOrDefault
		
		return result;
	}
	
	
	
	
	
	
	public boolean add(User data) {
		boolean result = false;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(data);
			entityManager.getTransaction().commit();
			
			result = true;
		}
		catch (Exception e) {
			// log something (if need)
		}
		
		return result;
	}
	
	public boolean add(List<User> data) {
		boolean result = false;
		try {
			entityManager.getTransaction().begin();
			for(var i : data)
			{
				entityManager.persist(i);
			}
			entityManager.getTransaction().commit();
			
			result = true;
		}
		catch (Exception e) {
			// log something (if need)
		}
		
		return result;
	}
	
	public boolean delete(User data) {
		boolean result = false;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(data);
			entityManager.getTransaction().commit();
			
			result = true;
		}
		catch (Exception e) {
			// log something (if need)
		}
		
		return result;
	}
	
	public boolean delete(List<User> data) {
		boolean result = false;
		try {
			entityManager.getTransaction().begin();
			for(var i : data)
			{
				entityManager.remove(i);
			}
			entityManager.getTransaction().commit();
			
			result = true;
		}
		catch (Exception e) {
			// log something (if need)
		}
		
		return result;
	}
}
