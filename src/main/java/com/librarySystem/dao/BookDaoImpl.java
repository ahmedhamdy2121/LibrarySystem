package com.librarySystem.dao;

import javax.persistence.Query;

import com.librarySystem.entity.Book;

public class BookDaoImpl extends GenericDAOImpl<Book> implements BookDao {

	@Override
	public Book findByISBN(String isbn) {
		Query query = em.createQuery("SELECT b FROM Book b where b.isbn = :isbn");
		query.setParameter("isbn", isbn);
		return (Book) query.getSingleResult();
	}

	@Override
	public void remove(long index) {
		em.remove(getByIndex(index));
	}

	@Override
	public Book getByIndex(long index) {
		return (Book) em.find(Book.class, index);
	}

}
