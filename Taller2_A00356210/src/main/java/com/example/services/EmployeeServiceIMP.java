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
					employeeR.insert(e);
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
					Optional<Employee> temp = employeeR.get(id);
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
					employeeR.insert(e);
				}
				
			
		}

		
	}
	
	public Iterable<Employee> findAll(){
		return employeeR.findAll();
	}
	
	@Override
	public void addPersonEmployee(Integer id, Integer person) {
		employeeR.get(id).get().setPerson(person);
		
	}
	public long size() {
		
		return employeeR.findAll().size();
	}
	@Override
	public void upDateEmployee(Employee e) {
		employeeR.update(e);
		
	}

}
