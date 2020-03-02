package com.librarySystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ls");
	private static EntityManager em = factory.createEntityManager();

	public void add(T t) {
		em.persist(t);
	}

	public boolean update(int index, T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public T getByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void apply(TransactionManager tManager) {
		em.getTransaction().begin();
		
		tManager.apply();
		
		em.getTransaction().commit();
	}

}
