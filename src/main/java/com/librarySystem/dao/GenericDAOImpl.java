package com.librarySystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private T t;

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ls");
	private static EntityManager em = factory.createEntityManager();

	public void add(T t) {
		em.persist(t);
	}

	public void update(int index, T t) {
		em.merge(t);
	}

	public void remove(int index) {
		em.remove(getByIndex(index));
	}

	public T getByIndex(int index) {
		return (T) em.find(t.getClass(), index);
	}

	public List<T> getAll() {
		Query query = em.createQuery("SELECT t FROM " + t.getClass() + " t");
		return query.getResultList();
	}
}
