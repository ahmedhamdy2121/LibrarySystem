package com.librarySystem.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public void add(T t);

	public void update(int index, T t);

	public void remove(long index);

	public T getByIndex(long index);

	public List<T> getAll(Class<T> t);

}
