package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.user.User;
import com.example.model.user.UserType;
import com.example.repositories.UserRepository;
@Service
public class UserServiceIMPL implements UserService{

	private UserRepository userRepository;

    @Autowired
    public void UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserType[] getTypes() {
        return UserType.values();
    }

    @Override
    public void save(User user) {
        System.out.println("-----guardado en el servicio de usuario------" + user.getUsername() + "----------------");
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.of(userRepository.findByUserName(userName));
    }


	
}
