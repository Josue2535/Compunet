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
import com.example.services.EmailAddressServiceIMPL;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeedepartmenthistoryServiceIMPL;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;
import com.example.services.ShiftServiceIMPL;
import com.example.services.UserServiceIMPL;
import com.example.daoimpl.EmployeeDAOimpl;
import com.example.daoimpl.EmployeepayhistoryDAOimpl;
import com.example.daoimpl.PersonDAOimpl;
import com.example.daoimpl.*;
import com.example.model.person.Emailaddress;
import com.example.model.person.Person;
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
	private static ShiftServiceIMPL sh1;
	private static EmailAddressServiceIMPL em1;
	
	private static PersonDAOimpl pdao;
	private static EmployeeDAOimpl emdao;
	private static EmployeepayhistoryDAOimpl paydao;
	private static DepartmentDAOimpl depaDao;
	private static EmployeedepartmenthistoryDAOimpl historydao;
	private static ShiftDAOimpl shdao;
	private static EmailAddressDAOimpl mailDao;
	
	
	
	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(application.class, args);
		
		ps = context.getBean(PersonServiceIMPL.class);
		es = context.getBean(EmployeeServiceIMP.class);
		ephs = context.getBean(EmployeepayhistoryServiceIMPL.class);
		ds = context.getBean(DepartmentServiceIMPL.class);
		edhs = context.getBean(EmployeedepartmenthistoryServiceIMPL.class);
		em1= context.getBean(EmailAddressServiceIMPL.class);
		
		Emailaddress a = new Emailaddress();
		
		a.setId(1);
		a.setEmailaddress("juanher@");
		
		em1.saveEmail(a);
		
		

		
	}
	
		
}
