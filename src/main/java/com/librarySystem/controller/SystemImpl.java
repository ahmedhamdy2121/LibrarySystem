package com.librarySystem.controller;

import javax.persistence.EntityTransaction;

import com.librarySystem.dao.GenericDAOImpl;
import com.librarySystem.entity.Person;

/**
 * @author ahmed hamdy
 *
 */
public abstract class SystemImpl {
    
	protected static Person currentLoggedUser;
	protected EntityTransaction et = GenericDAOImpl.getTransaction();
	
    public Privilege getPermission() {
        if (currentLoggedUser == null)
            return Privilege.NONE;
    	return Privilege.valueOf(currentLoggedUser.getPermissions());
    }
}
