package com.librarySystem.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	void apply(TransactionManager tManager);

	public void add(T t);

	public boolean update(int index, T t);

	public boolean remove(int index);

	public T getByIndex(int index);

	public List<T> getAll();

}
