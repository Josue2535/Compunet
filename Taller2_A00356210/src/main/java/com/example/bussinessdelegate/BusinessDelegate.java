package com.example.bussinessdelegate;

import java.util.List;

import org.springframework.web.client.RestTemplate;
import com.example.model.hr.*;

public interface BusinessDelegate {
	
	void setRestTemplate(RestTemplate restTemplate);
	
	//Department
	List<Department> findAllDepartmentByDepartmentId(Integer id);
	List<Department> findAllDepartments();
	
	
	//Employeedepartmenthistory

	
	//Employeepayhistory
	
	//Percon
	
	//Employee
	
	
}
