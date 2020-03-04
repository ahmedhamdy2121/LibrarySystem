package com.librarySystem.dao;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.librarySystem.entity.Book;

public class BookDaoImpl extends GenericDAOImpl<Book> implements BookDao {

	@Override
	public Book findByISBN(int isbn) {
		Book book = null;
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT b FROM Book b where b.isbn = :isbn");
			query.setParameter("isbn", isbn);
			book = (Book) query.getSingleResult();
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
		return book;

	}

}
