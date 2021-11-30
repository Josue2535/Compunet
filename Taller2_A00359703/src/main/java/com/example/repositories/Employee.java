package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Employee extends CrudRepository<com.example.model.hr.Employee, Integer>{

}
