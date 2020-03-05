package com.librarySystem.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.librarySystem.controller.BookController;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;
import com.librarySystem.controller.CredentialController;
import com.librarySystem.controller.LibrarySystemException;
import com.librarySystem.controller.Privilege;
import com.librarySystem.dao.BookDao;
import com.librarySystem.dao.BookDaoImpl;
import com.librarySystem.dao.GenericDAOImpl;
import com.librarySystem.dao.MemberDao;
import com.librarySystem.dao.MemberDaoImpl;
import com.librarySystem.dao.PersonDao;
import com.librarySystem.dao.PersonDaoImpl;
import com.librarySystem.entity.Address;
import com.librarySystem.entity.Author;
import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookCopy;
import com.librarySystem.entity.CheckoutEntry;
import com.librarySystem.entity.CheckoutRecord;
import com.librarySystem.entity.Member;
import com.librarySystem.entity.Person;

public class Test {
    
    private EntityTransaction et = GenericDAOImpl.getTransaction();

	public static void main(String[] args) throws LibrarySystemException {
		Test t = new Test();
		
//		t.createUsers();
//		t.createBooks();
//		t.createMembers();
		
		t.testLogin();
		t.testCheckoutBook();
		//t.testHibernate();
	}
	
	public void createUsers() {
	    try {
	        et.begin();

	        PersonDao pDao = new PersonDaoImpl();
	        
	        // create librarian
	        pDao.add(new Person("ahmed", "123", Privilege.LIBRARIAN.getValue()));
	        
	        // create admin
	        pDao.add(new Person("mohamed", "456", Privilege.ADMIN.getValue()));
	        
	        // create both
	        pDao.add(new Person("abd el salam", "789", Privilege.BOTH.getValue()));

	        et.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (et != null)
	            et.rollback();
	    } 

	}
	
	public void createBooks() {
	    try {
            et.begin();

            BookDao bDoa = new BookDaoImpl();
            
            List<Author> authors = new ArrayList<>();
            List<BookCopy> bookCopies = new ArrayList<>();
            
            Book b1 = new Book("book 1", "123-456", null, 
                               null, Book.BORROW_DURATION__7);
            
            bookCopies.add(new BookCopy(null, true, null, b1));
            authors.add(new Author("au 1", "au 11", "123", "fuck you", 
                        new Address("st1", "c1", "s1", "123"), Arrays.asList(b1)));
            
            b1.setAuthors(authors);
            b1.setBookCopyList(bookCopies);
            
            bDoa.add(b1);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null)
                et.rollback();
        } 
	}
	
	public void createMembers() {
	    try {
            et.begin();

            MemberDao mDoa = new MemberDaoImpl();
            
            Member m1 = new Member("member 1", "L1", "2354", 
                                  new Address("st1", "c1", "s1", "123"), 
                                  null, null);
            m1.setCheckoutRecord(new CheckoutRecord(0, m1, 
                                 new ArrayList<CheckoutEntry>()));

            mDoa.add(m1);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null)
                et.rollback();
        } 
	}
	
	public void testLogin() throws LibrarySystemException {
        CredentialController c = ControllerFactory.getController(Controller.Credential);
        System.out.println(c.login("ahmed", "123"));
        System.out.println(c.getPermission());
	}
	
	public void testCheckoutBook() throws LibrarySystemException {
	    BookController b = ControllerFactory.getController(Controller.Book);
	    System.out.println(b.checkoutBook(29, "123-456"));
	}
	
	public void testHibernate() {
		try {
			et.begin();

			Book book = new Book();

			String bookTitle = "bla bla bla bla";
			String isbn = "1234";
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
