package com.example.bussinessdelegate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.model.hr.Department;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeedepartmenthistory;
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;

public class BusinessDelegateImpl implements BusinessDelegate {

	private final static String URL = "http://localhost:8080/api";
	private final static String DEPARTMENT = URL + "/department/";
	private final static String GRUPNAME = DEPARTMENT + "/search/groupname/";
	private final static String PERSON = URL + "/person/";
	private final static String EMPLOYEE = URL + "/employee/";
	private final static String DATE = EMPLOYEE + "/search/";
	private final static String PAY = URL + "/historypay/";
	private final static String DEPARTMENTHISTORY = URL + "/historydepartment/";
	
	private RestTemplate restTemplate;
	
	public BusinessDelegateImpl() {
        this.restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public void setRestTemplate(RestTemplate restTemplate) {
		// TODO Auto-generated method stub
		this.restTemplate = restTemplate;
	}

	@Override
	public Department findByDepartmentId(Integer id) {
		return restTemplate.getForObject(DEPARTMENT+id, Department.class);
	}

	@Override
	public List<Department> findAllDepartments() {
		Department[] array = restTemplate.getForObject(DEPARTMENT, Department[].class);

        return Arrays.asList(array);
	}

	@Override
	public void deleteDepartment(Integer id) {
		// TODO Auto-generated method stub
		restTemplate.delete(DEPARTMENT+id);
	}

	@Override
	public void updateDepartment(Department de) {
		// TODO Auto-generated method stub
		restTemplate.put(DEPARTMENT, de, Department.class);
	}

	@Override
	public List<Department> getAllByNameGroup(String name) {
		// TODO Auto-generated method stub
		Department[] array = restTemplate.getForObject(GRUPNAME+name, Department[].class);

        return Arrays.asList(array);

	}
	
	//----------------------------- DEPARTMENT HISTORY --------------------------------------------

	@Override
	public List<Employeedepartmenthistory> indexDepartmentHistory() {
		Employeedepartmenthistory[] array = restTemplate.getForObject(DEPARTMENTHISTORY, Employeedepartmenthistory[].class);

        return Arrays.asList(array);
	}

	@Override
	public void updateDepartmentHistory(Employeedepartmenthistory de) {
		restTemplate.put(DEPARTMENTHISTORY, de, Employeedepartmenthistory.class);
		
	}

	@Override
	public void deleteDepartmentHistory(Integer id) {
		// TODO Auto-generated method stub
		restTemplate.delete(DEPARTMENTHISTORY+id);
	}

	@Override
	public Employeedepartmenthistory getByIdDepartmentHistory(Integer id) {
		return restTemplate.getForObject(DEPARTMENTHISTORY+id, Employeedepartmenthistory.class);
	}
	
	//-----------------------------------EMPLOYEE PAY HISTORY --------------------------------------

	@Override
	public List<Employeepayhistory> indexPayHistory() {
		Employeepayhistory[] array = restTemplate.getForObject(PAY, Employeepayhistory[].class);

        return Arrays.asList(array);
	}

	@Override
	public void updatePayHistory(Employeepayhistory de) {
		// TODO Auto-generated method stub
		restTemplate.put(PAY, de, Employeepayhistory.class);
	}

	@Override
	public void deletePayHistory(Integer id) {
		// TODO Auto-generated method stub
		restTemplate.delete(PAY+id);
	}

	@Override
	public Employeepayhistory getEmployeePayHistoryById(Integer id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(PAY+id, Employeepayhistory.class);
	}
	
	//----------------------------PERSON ----------------------------------------
	@Override
	public List<Person> indexPerson() {
		Person[] array = restTemplate.getForObject(PERSON, Person[].class);

        return Arrays.asList(array);
	}

	@Override
	public void updatePerson(Person de) {
		// TODO Auto-generated method stub
		restTemplate.put(PERSON, de, Person.class);
	}

	@Override
	public void deletePerson(Integer id) {
		// TODO Auto-generated method stub
		restTemplate.delete(PERSON+id);
	}

	@Override
	public Person getPersonById(Integer id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(PERSON+id, Person.class);
	}
//-------------------------- EMPLOYEE ---------------------------------------------
	@Override
	public List<Employee> indexEmployee() {
		Employee[] array = restTemplate.getForObject(EMPLOYEE, Employee[].class);

        return Arrays.asList(array);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(EMPLOYEE+id, Employee.class);
	}

	@Override
	public List<Employee> getAllByDates(Date date) {
		Employee[] array = restTemplate.getForObject(DATE+date.toString(), Employee[].class);

        return Arrays.asList(array);
	}

	@Override
	public void updateEmployee(Employee de) {
		restTemplate.put(EMPLOYEE, de, Employee.class);
		
	}

	@Override
	public List<Employee> getAllBetwenDates(Date date1, Date date2) {
		Employee[] array = restTemplate.getForObject(DATE+date1+"/"+date2.toString(), Employee[].class);

        return Arrays.asList(array);
	}

}
