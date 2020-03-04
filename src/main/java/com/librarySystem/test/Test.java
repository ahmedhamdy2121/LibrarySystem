package com.librarySystem.test;

import javax.persistence.EntityTransaction;

import com.librarySystem.controller.BookController;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;
import com.librarySystem.controller.CredentialController;
import com.librarySystem.dao.BookDao;
import com.librarySystem.dao.BookDaoImpl;
import com.librarySystem.dao.GenericDAOImpl;
import com.librarySystem.dao.PersonDao;
import com.librarySystem.dao.PersonDaoImpl;
import com.librarySystem.entity.Book;
import com.librarySystem.entity.Person;

public class Test {

	public static void main(String[] args) {
	    
	    BookController b = ControllerFactory.getController(Controller.Book);
        CredentialController c = ControllerFactory.getController(Controller.Credential);
        
//        System.out.println(b.addNewBook(null));
        System.out.println(c.getPermission());
        System.out.println(c.getPermission().getValue());
	    
		Test t = new Test();
		t.test();
	}

	public void test() {
		EntityTransaction et = GenericDAOImpl.getTransaction();
		try {
			et.begin();

			Book book = new Book();

			String bookTitle = "bla bla bla bla";
			int isbn = 12356;
			book.setTitle(bookTitle);
			book.setIsbn(isbn);

			BookDao bookDao = new BookDaoImpl();

			System.out.println("=========================> " + bookDao.add(book).getId());

			bookDao.getAll(Book.class).forEach((b) -> System.out.println(b.getId() + ": " + b.getTitle()));

			System.out.println("=========================> " + bookDao.findByISBN(isbn).getTitle());

			PersonDao personDao = new PersonDaoImpl();

			String userName = "mohamed alaaeldin";
			String password = "password_1";
			Person p = new Person(userName, password, 1234);

			System.out.println("=========================> " + personDao.add(p).getId());

			System.out.println("=========================> " + personDao.login(userName, password).getUserName());

			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
	}

}
