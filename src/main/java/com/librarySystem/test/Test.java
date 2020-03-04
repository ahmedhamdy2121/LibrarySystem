package com.librarySystem.test;

import com.librarySystem.dao.BookDaoImpl;
import com.librarySystem.dao.GenericDAO;
import com.librarySystem.entity.Book;

public class Test {

	public static void main(String[] args) {
		
		Book book = new Book();
		
		book.setTitle("mindset");
		
		GenericDAO<Book> bookDao = new BookDaoImpl();
		
		bookDao.add(book);
		
		bookDao.getAll(Book.class).forEach((b) -> System.out.println(b.getId() + ": " +b.getTitle()));
		
	}

}
