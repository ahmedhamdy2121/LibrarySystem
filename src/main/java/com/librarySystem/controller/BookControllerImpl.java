package com.librarySystem.controller;

import java.util.List;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookCopy;
import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public class BookControllerImpl extends SystemImpl implements BookController {

    @Override
    public Member checkoutBook(String memberID, String bookISBN)
            throws LibrarySystemException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Member viewCheckoutRecord(String memberID)
            throws LibrarySystemException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookCopy> getBookOverdueCopies(String bookISBN)
            throws LibrarySystemException {
        // TODO Auto-generated method stub
        return null;
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
