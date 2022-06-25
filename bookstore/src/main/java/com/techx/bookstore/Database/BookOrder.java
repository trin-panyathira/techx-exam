package com.techx.bookstore.Database;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class BookOrder implements Serializable {
	
	@EmbeddedId
	private BookOrderPK bookOrderPK;
	private int qty;
	private String createdBy;
	private Date createdDate;
	
	public BookOrder() {}
	public BookOrder(BookOrderPK bookOrderPK, int qty) {
		this.bookOrderPK = bookOrderPK;
		this.qty = qty;
	}

	public BookOrderPK getBookOrderPK() {
		return bookOrderPK;
	}
	public void setBookOrderPK(BookOrderPK bookOrderPK) {
		this.bookOrderPK = bookOrderPK;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
