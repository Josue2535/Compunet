package com.example.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.user.User;
import com.example.model.user.UserType;
@Service
public interface UserService {
	Optional<User> findById(int id);

    Iterable<User> findAll();

    void save(User userr);

    UserType[] getTypes();
    Optional<User> findByUserName(String userName);
}
