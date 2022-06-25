package com.techx.bookstore.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.techx.bookstore.Database.Book;
import com.techx.bookstore.Database.BookOrder;
import com.techx.bookstore.Database.User;
import com.techx.bookstore.model.BookModel;
import com.techx.bookstore.repository.interfaces.IBookRepo;

@Repository
public class BookRepo implements IBookRepo {
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
	private EntityManager entityManager = emf.createEntityManager();
	
//	public int test() {
////		var dataDBTmp = entityManager.find(Book.class, 1);
////		var dataDBTmpName = dataDBTmp.getName();
////		System.out.println("dataDBTmpName: "+ dataDBTmpName);
//		
//
//		var query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
//		List<Book> dataDB = query.getResultList();
//		String name = dataDB.get(1).getName();
//		
//		var result = 0;
//		
////		var query = entityManager.createQuery("SELECT count(b) FROM Book b");
////		var result2 = (int)query.getFirstResult();
////		
//		
//		return result;
//	}

	public List<Book> getBook() {
		
		var query = entityManager.createQuery("SELECT a from Book a ORDER BY a.isRecommended DESC, a.name ASC", Book.class);
		List<Book> result = query.getResultList();
		
		return result;
	}
	
	public List<Book> getBookByIds(List<Integer> ids) {
		
		var preQuery = entityManager.createQuery("SELECT a from Book a WHERE a.id IN (?1)", Book.class);
		var query = preQuery.setParameter(1, ids);
		List<Book> result = query.getResultList();
		
		return result;
	}

	public List<BookOrder> getOrderBookByUserId(int userId) {
		
		var queryPre = entityManager.createQuery("SELECT a from BookOrder a WHERE a.bookOrderPK.userId = ?1", BookOrder.class);
		var query = queryPre.setParameter(1, userId);
		List<BookOrder> result = query.getResultList();
		
		return result;
	}

	
	
	
	
	public boolean add(List<BookOrder> data) {
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
	
	public boolean add(BookOrder data) {
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
	
	public boolean delete(BookOrder data) {
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
	
	public boolean delete(List<BookOrder> data) {
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
