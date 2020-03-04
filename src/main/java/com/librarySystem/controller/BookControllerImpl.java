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
public class BookControllerImpl extends SystemImpl implements BookController {

    @Override
    public Member checkoutBook(long memberID, String bookISBN)
            throws LibrarySystemException {
        
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
                 LocalDate.now(), null, bookCopy));
        
        // Persistence
        mDao.update(member);
        bDao.update(book);
    }
    
    @Override
    public Member viewCheckoutRecord(long memberID)
            throws LibrarySystemException {

        MemberDao mDao = new MemberDaoImpl();
        Member member = mDao.getByIndex(memberID);
        
        if (member == null)
            throw new LibrarySystemException("Member not found");
        
        return member;
    }

    @Override
    public List<BookCopy> getBookOverdueCopies(String bookISBN)
            throws LibrarySystemException {

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
        
        return overDueBookCopies;
    }

    @Override
    public boolean addNewBook(Book book) throws LibrarySystemException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addNewCopy(String ISBN, int additionalCopies)
            throws LibrarySystemException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Book getBookByISBN(String ISBN) throws LibrarySystemException {
        // TODO Auto-generated method stub
        return null;
    }

}
