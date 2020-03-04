package com.librarySystem.dao;

import com.librarySystem.entity.Book;

public interface BookDao {
	
	Book findByISBN(int isbn);

}
