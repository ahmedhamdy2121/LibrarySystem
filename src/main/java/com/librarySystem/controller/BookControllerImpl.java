package com.librarySystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.librarySystem.dao.BookDao;
import com.librarySystem.dao.BookDaoImpl;
import com.librarySystem.dao.MemberDao;
import com.librarySystem.dao.MemberDaoImpl;
import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookCopy;
import com.librarySystem.entity.CheckoutEntry;
import com.librarySystem.entity.CheckoutRecord;
import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public class BookControllerImpl extends LibrarySystemImpl 
        implements BookController {

    @Override
    public Member checkoutBook(long memberID, String bookISBN)
            throws LibrarySystemException {
        
        // validation
        if (memberID < 0)
            throw new LibrarySystemException("Member ID can't be negative");
        if (bookISBN == null || bookISBN.isEmpty())
            throw new LibrarySystemException("Book ISBN can't be empty");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.LIBRARIAN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();
            
            MemberDao mDao = new MemberDaoImpl();
            Member member = mDao.getByIndex(memberID);
            
            BookDao bDao = new BookDaoImpl();
            Book book = bDao.findByISBN(bookISBN);
            
            if (member == null)
                throw new LibrarySystemException("Member not found");
            if (book == null)
                throw new LibrarySystemException("Book not found");
            
            // logic
            CheckoutRecord record = member.getCheckoutRecord();
            List<CheckoutEntry> entries = record.getCheckoutEntryList();
            
            // check if there is available copies
            List<BookCopy> bookCopies = book.getBookCopyList();
            
            BookCopy bookCopy = null;
            for (BookCopy copy: bookCopies) {
                if (copy.isAvailable()) {
                    copy.setAvailable(false);
                    bookCopy = copy;
                    break;
                }
            }
            
            if (bookCopy == null)
                throw new LibrarySystemException("There is no available copies");
            
            entries.add(new CheckoutEntry
                    (0, java.sql.Date.valueOf(LocalDate.now()
                            .plusDays(book.getBorrowDuration())), 
                     new Date(), null, bookCopy));
            
            member.setBookCopy(bookCopy);
            
            // Persistence
            mDao.update(member);
            bDao.update(book);
            
            et.commit();
            
            return member;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                    + "with the database!");
        }
        
    }
    
    @Override
    public Member viewCheckoutRecord(long memberID)
            throws LibrarySystemException {
        
        // validation
        if (memberID < 0)
            throw new LibrarySystemException("Member ID can't be negative");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.LIBRARIAN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            MemberDao mDao = new MemberDaoImpl();
            Member member = mDao.getByIndex(memberID);
            
            if (member == null)
                throw new LibrarySystemException("Member not found");
            
            et.commit();
            
            return member;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                    + "with the database!");
        }
        
    }

    @Override
    public List<BookCopy> getBookOverdueCopies(String bookISBN)
            throws LibrarySystemException {

        // validation
        if (bookISBN == null || bookISBN.isEmpty())
            throw new LibrarySystemException("Book ISBN can't be empty");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.LIBRARIAN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            BookDao bDao = new BookDaoImpl();
            Book book = bDao.findByISBN(bookISBN);
            
            if (book == null)
                throw new LibrarySystemException("Book not found");
            
            // logic
            List<BookCopy> bookCopies = book.getBookCopyList();

            List<BookCopy> overDueBookCopies = new ArrayList<>();
            for (BookCopy copy: bookCopies) {
                if (copy.getDueDate().before(new Date()) 
                        && (! copy.isAvailable()))
                    overDueBookCopies.add(copy);
            }
            
            et.commit();
            
            return overDueBookCopies;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                    + "with the database!");
        }
        
    }

    @Override
    public Book addNewBook(Book book) throws LibrarySystemException {
        
        // validation
        if (book == null)
            throw new LibrarySystemException("Book is null");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.ADMIN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            BookDao mDao = new BookDaoImpl();
            Book updatedBook = mDao.add(book);

            et.commit();
            
            return updatedBook;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
        
    }

    @Override
    public Book addNewCopy(String bookISBN, int additionalCopies)
            throws LibrarySystemException {
        
        // validation
        if (additionalCopies <= 0)
            throw new LibrarySystemException("Book copies can't be 0 or "
                    + "or negative");
        if (bookISBN == null || bookISBN.isEmpty())
            throw new LibrarySystemException("Book is null");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.ADMIN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            BookDao bDao = new BookDaoImpl();
            Book book = bDao.findByISBN(bookISBN);

            // logic
            List<BookCopy> bookCopies = book.getBookCopyList();
            
            for (int i = 0; i < additionalCopies; i++) {
                bookCopies.add(new BookCopy(null, true, null, book));
            }
            
            et.commit();
            
            return book;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
        
    }

    @Override
    public Book getBookByISBN(String bookISBN) throws LibrarySystemException {

        // validation
        if (bookISBN == null || bookISBN.isEmpty())
            throw new LibrarySystemException("Book ISBN can't be empty");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.LIBRARIAN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            BookDao bDao = new BookDaoImpl();
            Book book = bDao.findByISBN(bookISBN);
            
            et.commit();
            
            return book;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
        
    }

}
