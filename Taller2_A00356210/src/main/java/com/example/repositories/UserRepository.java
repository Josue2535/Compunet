package com.example.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.user.User;
@Repository
public interface UserRepository extends CrudRepository<com.example.model.user.User, Integer> {
	
    User findByUserName(String userName);

    

}
