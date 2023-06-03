package com.restau.localisationRes.dao;

import java.util.List;

public interface IDao <T> {
	
	void save (T o);
	List<T> findAll();
	void delete(T o);
	void update(T o);
	T findById(int id);
}
