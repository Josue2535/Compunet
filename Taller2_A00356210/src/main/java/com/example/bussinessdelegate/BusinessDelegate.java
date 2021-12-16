package com.example.bussinessdelegate;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.example.model.hr.*;
import com.example.model.person.Person;

public interface BusinessDelegate {
	
	void setRestTemplate(RestTemplate restTemplate);
	
	//Department
	Department findByDepartmentId(Integer id);
	List<Department> findAllDepartments();
	void deleteDepartment(Integer id);
	void updateDepartment(Department de);
	List<Department> getAllByNameGroup(String name);
	
	//Employeedepartmenthistory
	List<Employeedepartmenthistory> indexDepartmentHistory();
	void updateDepartmentHistory(Employeedepartmenthistory de);
	void deleteDepartmentHistory(Integer id);
	Employeedepartmenthistory getByIdDepartmentHistory( Integer id);
	
	//Employeepayhistory
	List<Employeepayhistory> indexPayHistory();
	void updatePayHistory( Employeepayhistory de);
	void deletePayHistory(@PathVariable("id") Integer id);
	Employeepayhistory getEmployeePayHistoryById(Integer id);
	//Person
	List<Person> indexPerson();
	void updatePerson( Person de);
	void deletePerson(Integer id);
	Person getPersonById(Integer id);
	//Employee
	List<Employee> indexEmployee();
	Employee getEmployeeById(Integer id);
	List<Employee> getAllByDates(Date date);
	void updateEmployee(Employee de);
	List<Employee> getAllBetwenDates( Date date1, Date date2);
	
	
	
}
