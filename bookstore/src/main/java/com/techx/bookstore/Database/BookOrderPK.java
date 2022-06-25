package com.techx.bookstore.Database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class BookOrderPK implements Serializable {

	private int userId;
	private int bookId;
	
	public BookOrderPK() {}
	public BookOrderPK(int userId, int bookId) {
		this.userId = userId;
		this.bookId = bookId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOrderPK bookOrderPK = (BookOrderPK) o;
        return userId == bookOrderPK.userId && bookId == bookOrderPK.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId);
    }
}
