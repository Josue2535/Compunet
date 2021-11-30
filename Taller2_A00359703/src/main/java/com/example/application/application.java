package com.example.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.services.UserServiceIMPL;
import com.example.model.user.User;
import com.example.model.user.UserType;
import com.example.repositories.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class application{
	public static void main(String[] args) {
		SpringApplication.run(application.class, args);
	}
}
