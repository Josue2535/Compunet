package com.example.services;

import org.springframework.stereotype.Service;

import com.example.model.hr.Department;
@Service
public interface departmentService{
	public void saveDepartment(Department d);
	public void upDateDepartment(Department d);
	public Department findDepartmentById(Integer id);
	void delete(Integer id);
}
