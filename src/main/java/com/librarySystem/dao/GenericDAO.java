package com.librarySystem.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public T add(T t);

	public T update(T t);

	public void remove(long index);

	public T getByIndex(long index);

	public List<T> getAll(Class<T> t);

}
