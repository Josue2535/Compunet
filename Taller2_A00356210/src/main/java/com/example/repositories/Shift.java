package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Shift extends CrudRepository<com.example.model.hr.Shift, Integer>{

}
