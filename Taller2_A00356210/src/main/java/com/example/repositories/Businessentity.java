package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Businessentity extends CrudRepository<com.example.model.person.Businessentity, Integer> {

}
