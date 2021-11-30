package com.example.services;

import org.springframework.stereotype.Service;

import com.example.model.hr.Employee;
import com.example.model.person.Person;
@Service
public interface EmployeeService {
	public void saveEmployee(Employee e);
	public void upDateEmployee(Employee e);
	public void addPersonEmployee(Integer id, Person person);
	void upDateEmployee(Employee e, Integer id);
}
