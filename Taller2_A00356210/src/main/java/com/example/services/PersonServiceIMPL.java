package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoimpl.PersonDAOimpl;
import com.example.model.hr.Employee;
import com.example.model.person.Person;
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
			
			personRepo.insert(p);
		}
		
	}

	@Override
	public Person findPersonById(Integer id) {
		Person temp = personRepo.get(id).get();
		return temp;
	}

	@Override
	public ArrayList<Person> findAll() {
		
		return (ArrayList<Person>) personRepo.findAll();
	}

	@Override
	public void deletPerson(Integer id) {
		personRepo.delete(personRepo.get(id).get());
	}

	@Override
	public void addEmployeePerson(Integer id, Integer employee) {
		personRepo.get(id).get().setEmployee(employee);
		
	}
	@Override
	public void upDatePerson(Person p, Integer id) {
		Person temp = personRepo.get(id).get();
		temp.setAdditionalcontactinfo(p.getAdditionalcontactinfo());
		temp.setBusinessentity(p.getBusinessentity());
		temp.setBusinessentitycontacts(p.getBusinessentitycontacts());
		temp.setDemographics(p.getDemographics());
		temp.setEmailaddresses(p.getEmailaddresses());
		temp.setEmailpromotion(p.getEmailpromotion());
		temp.setEmailaddresses(p.getEmailaddresses());
		temp.setEmployee(p.getEmployee());
		temp.setFirstname(p.getFirstname());
		temp.setMiddlename(p.getMiddlename());
		temp.setLastname(p.getLastname());
		temp.setModifieddate(p.getModifieddate());
		temp.setNamestyle(p.getNamestyle());
		temp.setPassword(p.getPassword());
		temp.setPersonphones(p.getPersonphones());
		temp.setPersontype(p.getPersontype());
		temp.setRowguid(p.getRowguid());
		temp.setTitle(p.getTitle());
		personRepo.insert(temp);
	}
	@Override
	public long size() {
		
		return personRepo.findAll().size();
	}
	
	

}
