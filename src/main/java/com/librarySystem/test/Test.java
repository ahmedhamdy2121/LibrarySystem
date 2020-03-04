package com.librarySystem.test;

import com.librarySystem.dao.BookDaoImpl;
import com.librarySystem.entity.Book;

public class Test {

	public static void main(String[] args) {

		Book book = new Book();

		book.setTitle("new mindset");
		book.setIsbn(123);

		BookDaoImpl bookDao = new BookDaoImpl();

		bookDao.add(book);

		bookDao.getAll(Book.class).forEach((b) -> System.out.println(b.getId() + ": " + b.getTitle()));

		System.out.println(bookDao.findByISBN(123).getTitle());

	}

}
