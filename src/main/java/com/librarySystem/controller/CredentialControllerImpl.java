package com.librarySystem.controller;

import com.librarySystem.entity.Person;

/**
 * @author ahmed hamdy
 *
 */
public class CredentialControllerImpl extends SystemImpl
        implements CredentialController {

    @Override
    public Person login(String username, String password)
            throws LibrarySystemException {
        if (currentLoggedUser == null)
            throw new LibrarySystemException("A user is already logged in");
        
        return null;
    }

}
