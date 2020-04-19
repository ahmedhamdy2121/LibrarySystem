package com.librarySystem.controller;

import com.librarySystem.entity.Person;

/**
 * @author ahmed hamdy
 *
 */
public abstract class LibrarySystemImpl implements LibrarySystem {
    
	protected static Person currentLoggedUser;
	
    public Privilege getPermission() {
        if (currentLoggedUser == null)
            return Privilege.NONE;
    	return Privilege.valueOf(currentLoggedUser.getPermissions());
    }
}
