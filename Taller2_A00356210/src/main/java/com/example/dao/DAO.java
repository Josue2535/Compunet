package com.example.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	Optional<T> get(Long id);

	List<T> getAll();

	void save(T t);

	//void update(T t, String[] params);
	void update(T t);
	
	void deleteById(Long t);
}
