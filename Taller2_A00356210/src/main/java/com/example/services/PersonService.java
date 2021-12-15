package com.example.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.model.hr.Employee;
import com.example.model.person.Person;

@Service
public interface PersonService {
	public void savePerson(Person p);
	public Person findPersonById(Integer id);
	public ArrayList<Person>findAll();
	public void deletPerson(Integer id);
	public void addEmployeePerson(Integer id, Integer employee);
	public void upDatePerson(Person p, Integer id);
	public long size();
	 
}
