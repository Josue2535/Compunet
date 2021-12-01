package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Person extends CrudRepository<com.example.model.person.Person, Integer>{

}
