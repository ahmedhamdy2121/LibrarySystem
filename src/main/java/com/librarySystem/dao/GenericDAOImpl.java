package com.librarySystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ls");
	private static EntityManager em = factory.createEntityManager();

	public void add(T t) {
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(t);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
	}

	public void update(int index, T t) {
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.merge(t);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
	}

	public void remove(int index) {
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.remove(getByIndex(index));
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
	}

	public T getByIndex(int index) {
		T t = null;
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			t = (T) em.find(t.getClass(), index);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
		return t;
	}

	public List<T> getAll(Class<T> t) {
		List<T> list = null;
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT t FROM " + t.getName() + " t");
			list = query.getResultList();
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
			e.printStackTrace();
		}
		return list;		
	}
}
