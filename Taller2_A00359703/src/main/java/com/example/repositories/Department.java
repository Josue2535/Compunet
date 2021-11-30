package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

@Repository
public interface Department extends CrudRepository<com.example.model.hr.Department, Integer> {
	
}
