package com.librarySystem.dao;

import com.librarySystem.entity.Book;

public interface BookDao extends GenericDAO<Book>{
	
	Book findByISBN(int isbn);

}
