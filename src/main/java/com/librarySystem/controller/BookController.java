package com.librarySystem.controller;

import java.util.List;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.BookCopy;
import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public interface BookController {
    
    /**
     * 
     * @param memberID
     * @param bookISBN
     * @return null if the book is not found or user not found
     * @throws LibrarySystemException
     */
    public Member checkoutBook(String memberID, String bookISBN) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param memberID
     * @return null if member not found
     * @throws LibrarySystemException
     */
    public Member viewCheckoutRecord(String memberID)
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
     * @return false if operation not succeeded
     * @throws LibrarySystemException
     */
    public boolean addNewBook(Book book) throws LibrarySystemException;
    
    /**
     * 
     * @param ISBN
     * @return false if book not found
     * @throws LibrarySystemException
     */
    public boolean addNewCopy(String ISBN, int additionalCopies) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param ISBN
     * @return null if book not found
     * @throws LibrarySystemException
     */
    public Book getBookByISBN(String ISBN) throws LibrarySystemException;
}
