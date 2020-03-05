package com.librarySystem.dao;

import com.librarySystem.entity.Book;

public interface BookDao extends GenericDAO<Book>{
	
	Book findByISBN(String isbn);
	
	public void remove(long index);

	public Book getByIndex(long index);

}
