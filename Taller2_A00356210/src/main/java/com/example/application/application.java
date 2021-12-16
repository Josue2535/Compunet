package com.example.application;


import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.services.DepartmentServiceIMPL;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeedepartmenthistoryServiceIMPL;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;
import com.example.services.UserServiceIMPL;
import com.example.model.user.User;
import com.example.model.user.UserType;
import com.example.repositories.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class application{
	private static PersonServiceIMPL ps;
	private static Integer c1;
	private static Integer c2;
	private static EmployeeServiceIMP es;
	private static EmployeepayhistoryServiceIMPL ephs;
	private static Integer soh1;
	private static Integer soh2;
	private static DepartmentServiceIMPL ds;
	private static Integer sod1;
	private static Integer sod2;
	private static EmployeedepartmenthistoryServiceIMPL edhs;
	private static Integer sp1;
	private static Integer sp2;
	
	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(application.class, args);
		
		ps = context.getBean(PersonServiceIMPL.class);
		es = context.getBean(EmployeeServiceIMP.class);
		ephs = context.getBean(EmployeepayhistoryServiceIMPL.class);
		ds = context.getBean(DepartmentServiceIMPL.class);
		edhs = context.getBean(EmployeedepartmenthistoryServiceIMPL.class);
		
		
		
	}
	
		
}
