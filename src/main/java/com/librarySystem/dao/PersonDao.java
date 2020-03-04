package com.librarySystem.dao;

import com.librarySystem.entity.Person;

public interface PersonDao extends GenericDAO<Person>{
	
	Person login(String userName, String password);

}
