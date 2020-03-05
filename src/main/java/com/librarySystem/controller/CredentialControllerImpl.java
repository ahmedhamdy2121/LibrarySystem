package com.librarySystem.controller;

import com.librarySystem.dao.PersonDao;
import com.librarySystem.dao.PersonDaoImpl;
import com.librarySystem.entity.Person;

/**
 * @author ahmed hamdy
 *
 */
public class CredentialControllerImpl extends SystemImpl
        implements CredentialController {

    @Override
    public Person login(String userName, String password)
            throws LibrarySystemException {
        
        // validation
        if (userName == null || userName.isEmpty())
            throw new LibrarySystemException("Username can't be empty");
        if (password == null || password.isEmpty())
            throw new LibrarySystemException("Password can't be empty");
        
        try {
            et.begin();

            PersonDao pDao = new PersonDaoImpl();
            Person person = pDao.login(userName, password);

            et.commit();
            
            this.currentLoggedUser = person;
            
            return person;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
        
    }

}
