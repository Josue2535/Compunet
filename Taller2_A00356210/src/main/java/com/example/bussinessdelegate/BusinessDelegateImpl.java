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
	private final static String PERSON = URL + "/person/";
	private final static String EMPLOYEE = URL + "/employee/";
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
		
	}

	@Override
	public void updateDepartment(Department de) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> getAllByNameGroup(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employeedepartmenthistory> indexDepartmentHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDepartmentHistory(Employeedepartmenthistory de) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartmentHistory(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employeedepartmenthistory getByIdDepartmentHistory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employeepayhistory> indexPayHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePayHistory(Employeepayhistory de) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePayHistory(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employeepayhistory getEmployeePayHistoryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> indexPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePerson(Person de) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPersonById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> indexEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllByDates(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee de) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllBetwenDates(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

}
