package com.librarySystem.dao;

import javax.persistence.Query;

import com.librarySystem.entity.Person;

public class PersonDaoImpl extends GenericDAOImpl<Person> implements PersonDao {

	@Override
	public Person login(String userName, String password) {
		Query query = em.createQuery("SELECT p FROM Person p where p.userName =:userName and p.password =:password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		return (Person) query.getSingleResult();
	}

}
