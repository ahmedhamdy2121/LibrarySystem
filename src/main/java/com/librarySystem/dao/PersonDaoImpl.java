package com.librarySystem.dao;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.librarySystem.entity.Person;

public class PersonDaoImpl extends GenericDAOImpl<Person> implements PersonDao {

	@Override
	public Person login(String userName, String password) {
		Person person = null;
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Query query = em
					.createQuery("SELECT p FROM Person p where p.userName =:userName and p.password =:password");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			person = (Person) query.getSingleResult();
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
		return person;
	}

}
