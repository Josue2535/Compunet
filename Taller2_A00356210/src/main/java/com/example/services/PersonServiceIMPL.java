package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoimpl.PersonDAOimpl;
import com.example.model.hr.Employee;
import com.example.model.person.Person;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class PersonServiceIMPL implements PersonService{
	private PersonDAOimpl personRepo;
	@Autowired
	public PersonServiceIMPL(PersonDAOimpl personRepo) {
		this.personRepo = personRepo;
	}
	@Override
	public void savePerson(Person p) {
		if(p.getTitle().length() >= 5) {
			
			personRepo.save(p);
		}
		
	}

	@Override
	public Person findPersonById(Integer id) {
		
		Person temp = personRepo.get(id).get();
		if(temp == null) {
			throw new NullPointerException();
		}
		return temp;
	}

	@Override
	public ArrayList<Person> findAll() {
		
		return (ArrayList<Person>) personRepo.getAll();
	}

	@Override
	public void deletPerson(Integer id) {
		personRepo.deleteById(id);
	}

	@Override
	public void addEmployeePerson(Integer id, Integer employee) {
		personRepo.get(id).get().setEmployee(employee);
		
	}
	@Override
	public void upDatePerson(Person p) {
		personRepo.update(p);
	}
	@Override
	public long size() {
		
		return personRepo.getAll().size();
	}
	
	

}
