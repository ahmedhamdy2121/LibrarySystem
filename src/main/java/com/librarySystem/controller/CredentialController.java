package com.librarySystem.controller;

import com.librarySystem.entity.Person;

/**
 * @author ahmed hamdy
 *
 */
public interface CredentialController extends LibrarySystem {
    
    /**
     * 
     * @param username
     * @param password
     * @return null if user not found
     */
    public Person login(String userName, String password) 
            throws LibrarySystemException;
}
