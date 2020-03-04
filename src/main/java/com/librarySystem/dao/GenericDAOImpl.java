package com.librarySystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ls");
	protected static EntityManager em = factory.createEntityManager();
	private static EntityTransaction et = em.getTransaction();

	public static EntityTransaction getTransaction() {
		return GenericDAOImpl.et;
	}
	
	public static void close() {
		em.close();
	}

	@Override
	public T add(T t) {
		em.persist(t);
		em.flush();
		return t;
	}

	@Override
	public T update(T t) {
		em.merge(t);
		em.flush();
		return t;
	}

	@Override
	public void remove(long index) {
		em.remove(getByIndex(index));
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public T getByIndex(long index) {
		T t = null;
		return (T) em.find(t.getClass(), index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> t) {
		List<T> list = null;
		Query query = em.createQuery("SELECT t FROM " + t.getName() + " t");
		list = query.getResultList();
		return list;
	}
}
