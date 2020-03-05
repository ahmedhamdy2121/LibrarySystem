package com.librarySystem.controller;

import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.librarySystem.dao.GenericDAOImpl;
import com.librarySystem.dao.PersonDao;
import com.librarySystem.dao.PersonDaoImpl;
import com.librarySystem.entity.Person;

/**
 * @author ahmed hamdy
 *
 */
public class CredentialControllerImpl extends LibrarySystemImpl
        implements CredentialController {

    @Override
    public Person login(String userName, String password)
            throws LibrarySystemException {
        
        // validation
        if (userName == null || userName.isEmpty())
            throw new LibrarySystemException("Username can't be empty");
        if (password == null || password.isEmpty())
            throw new LibrarySystemException("Password can't be empty");
        
        
        EntityTransaction et = GenericDAOImpl.getTransaction();
        try {
            et.begin();

            PersonDao pDao = new PersonDaoImpl();
            Person person = pDao.login(userName, password);

            et.commit();
            
            currentLoggedUser = person;
            
            return person;
            
        } catch (IllegalStateException | RollbackException e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
        
    }

}
