package com.librarySystem.controller;

import java.util.List;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookCopy;
import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public interface BookController extends System {
    
    /**
     * 
     * @param memberID
     * @param bookISBN
     * @return null if the book is not found or user not found
     * @throws LibrarySystemException
     */
    public Member checkoutBook(long memberID, String bookISBN) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param memberID
     * @return null if member not found
     * @throws LibrarySystemException
     */
    public Member viewCheckoutRecord(long memberID)
            throws LibrarySystemException;
    
    /**
     * 
     * @param bookISBN
     * @return list of overdue copies or empty list
     * @throws LibrarySystemException
     */
    public List<BookCopy> getBookOverdueCopies(String bookISBN) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param book
     * @return null if operation not succeeded
     * @throws LibrarySystemException
     */
    public Book addNewBook(Book book) throws LibrarySystemException;
    
    /**
     * 
     * @param ISBN
     * @return null if book not found
     * @throws LibrarySystemException
     */
    public Book addNewCopy(String bookISBN, int additionalCopies) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param ISBN
     * @return null if book not found
     * @throws LibrarySystemException
     */
    public Book getBookByISBN(String bookISBN) throws LibrarySystemException;
}
