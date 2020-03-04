package com.librarySystem.test;

import com.librarySystem.dao.BookDao;
import com.librarySystem.dao.BookDaoImpl;
import com.librarySystem.dao.PersonDao;
import com.librarySystem.dao.PersonDaoImpl;
import com.librarySystem.entity.Book;
import com.librarySystem.entity.Person;

public class Test {

	public static void main(String[] args) {

		Book book = new Book();

		String bookTitle = "bla bla bla";
		int isbn = 1235;
		book.setTitle(bookTitle);
		book.setIsbn(isbn);

		BookDao bookDao = new BookDaoImpl();

		bookDao.add(book);

		bookDao.getAll(Book.class).forEach((b) -> System.out.println(b.getId() + ": " + b.getTitle()));

		System.out.println("=========================> " + bookDao.findByISBN(isbn).getTitle());
		
		PersonDao personDao = new PersonDaoImpl();
		
		String userName = "mohamed keilany";
		String password = "password_1";
		Person p = new Person(userName, password, 1234);
		
		personDao.add(p);
		
		System.out.println("=========================> " + personDao.login(userName, password).getUserName());
		
	}

}
