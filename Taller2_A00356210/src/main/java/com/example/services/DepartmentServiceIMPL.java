package com.example.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoimpl.DepartmentDAOimpl;
import com.example.model.hr.Department;
@Service
public class DepartmentServiceIMPL implements departmentService{
	private DepartmentDAOimpl dr;
	@Autowired
	public DepartmentServiceIMPL(DepartmentDAOimpl dr) {
		this.dr = dr;
	}
	@Override
	public void saveDepartment(Department d) {
		if(d.getModifieddate().equals(LocalDate.now())) {
			if(d.getName().length()>=5 && d.getGroupname().length()>=5) {
				dr.save(d);
				System.out.println("guardo");
			}else {
				System.out.println("No guardo");
			}
	}
		
	}
		
	
	@Override
	public Department findDepartmentById(Integer id) {
		return dr.findById(id).get();
	}
	
	public List<Department> findAll(){
		return dr.getAll();
	}
	
	public Long size(){
		return (long) dr.getAll().size();
	}
	
	
	@Override
	public void upDateDepartment(Department department) {
		if(department.getModifieddate().equals(LocalDate.now())) {
			if(department.getName().length()>=5 && department.getGroupname().length()>=5) {
				dr.update(department);
				System.out.println("guardo");
			}else {
				System.out.println("No guardo");
			}
	}
		
	}
	
}
