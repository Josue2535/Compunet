package com.example.services;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.hr.Employee;
import com.example.model.person.Person;
@Service
public class EmployeeServiceIMP implements EmployeeService {
	private com.example.repositories.Employee employeeR;
	private com.example.repositories.Person personR;
	@Autowired
	public void EmployeepayhistoryServiceIMPL(com.example.repositories.Employee employeeR,com.example.repositories.Person personR) {
		this.employeeR = employeeR;
		this.personR = personR;
	}
	@Override
	public void saveEmployee(Employee e) {
		if(personR.findById(e.getBusinessentityid()) != null) {
			
				if(e.getJobtitle().length() >= 5) {
					employeeR.save(e);
				}
				
			
		}

	}
	public Employee findEmployeeByiD(Integer id) {
		Employee temp = employeeR.findById(id).get();
		return temp;
	}

	@Override
	public void upDateEmployee( Employee e, Integer id) {
		if(personR.findById(e.getBusinessentityid()) != null) {
			
				if(e.getJobtitle().length() >= 5) {
					Optional<Employee> temp = employeeR.findById(id);
					temp.get().setBirthdate(e.getBirthdate());
					temp.get().setCurrentflag(e.getCurrentflag());
					temp.get().setEmployeedepartmenthistories(e.getEmployeedepartmenthistories());
					temp.get().setEmployeepayhistories(e.getEmployeepayhistories());
					temp.get().setGender(e.getGender());
					temp.get().setHiredate(e.getHiredate());
					temp.get().setJobcandidates(e.getJobcandidates());
					temp.get().setJobtitle(e.getJobtitle());
					temp.get().setLoginid(e.getLoginid());
					temp.get().setMaritalstatus(e.getMaritalstatus());
					temp.get().setModifieddate(e.getModifieddate());
					temp.get().setNationalidnumber(e.getNationalidnumber());
					temp.get().setOrganizationnode(e.getOrganizationnode());
					temp.get().setRowguid(e.getRowguid());
					temp.get().setSalariedflag(e.getSalariedflag());
					temp.get().setSickleavehours(e.getSickleavehours());
					temp.get().setVacationhours(e.getVacationhours());
					employeeR.save(temp.get());
				}
				
			
		}

		
	}
	
	public Iterable<Employee> findAll(){
		return employeeR.findAll();
	}
	
	@Override
	public void addPersonEmployee(Integer id, Person person) {
		employeeR.findById(id).get().setPerson(person);
		
	}
	public long size() {
		
		return employeeR.count();
	}
	@Override
	public void upDateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

}
