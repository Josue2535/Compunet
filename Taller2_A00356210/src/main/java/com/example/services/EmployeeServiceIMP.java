package com.example.services;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PersonDAO;
import com.example.daoimpl.EmployeeDAOimpl;
import com.example.daoimpl.PersonDAOimpl;
import com.example.model.hr.Employee;
import com.example.model.person.Person;
@Service
public class EmployeeServiceIMP implements EmployeeService {
	private EmployeeDAOimpl employeeR;
	private PersonDAOimpl personR;
	@Autowired
	public void EmployeepayhistoryServiceIMPL(EmployeeDAOimpl employeeR,PersonDAOimpl personR) {
		this.employeeR = employeeR;
		this.personR = personR;
	}
	@Override
	public void saveEmployee(Employee e) {
		if(personR.get(e.getBusinessentityid()) != null) {
			
				if(e.getJobtitle().length() >= 5) {
					employeeR.save(e);
				}
				
			
		}

	}
	public Employee findEmployeeByiD(Integer id) {
		Employee temp = employeeR.get(id).get();
		return temp;
	}

	@Override
	public void upDateEmployee( Employee e, Integer id) {
		if(personR.get(e.getBusinessentityid()) != null) {
			
				if(e.getJobtitle().length() >= 5) {
					employeeR.update(e);
				}
				
			
		}

		
	}
	
	public Iterable<Employee> findAll(){
		return employeeR.getAll();
	}
	
	@Override
	public void addPersonEmployee(Integer id, Integer person) {
		employeeR.get(id).get().setPerson(person);
		
	}
	public long size() {
		
		return employeeR.getAll().size();
	}
	@Override
	public void upDateEmployee(Employee e) {
		employeeR.update(e);
		
	}

}
