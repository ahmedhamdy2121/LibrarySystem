package com.librarySystem.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	void apply(TransactionManager tManager);

	public void add(T t);

	public void update(int index, T t);

	public void remove(int index);

	public T getByIndex(int index);

	public List<T> getAll();

}
