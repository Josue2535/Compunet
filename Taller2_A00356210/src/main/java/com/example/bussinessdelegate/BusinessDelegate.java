package com.example.bussinessdelegate;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.example.model.hr.*;

public interface BusinessDelegate {
	
	void setRestTemplate(RestTemplate restTemplate);
	
	//Department
	List<Department> findAllDepartmentByDepartmentId(Integer id);
	List<Department> findAllDepartments();
	void deleteDepartment(Integer id);
	void updateDepartment(Department de);
	List<Department> getAllByNameGroup(String name);
	
	//Employeedepartmenthistory
	Iterable<Employeedepartmenthistory> indexDepartmentHistory();
	void updateDepartmentHistory(Employeedepartmenthistory de);
	void deleteDepartmentHistory(Integer id);
	Employeedepartmenthistory getById(@PathVariable("id") Integer id);
	
	//Employeepayhistory
	
	//Percon
	
	//Employee
	
	
}
