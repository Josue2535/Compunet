package com.example.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.hr.Department;
@Service
public class DepartmentServiceIMPL implements departmentService{
	private com.example.repositories.Department dr;
	@Autowired
	public DepartmentServiceIMPL(com.example.repositories.Department dr) {
		this.dr = dr;
	}
	@Override
	public void saveDepartment(Department d) {
		if(d.getModifieddate().equals(LocalDate.now())) {
			if(d.getName().length()>=5 && d.getGroupname().length()>=5) {
				dr.save(d);
				System.out.println("guardo" + dr.count());
			}else {
				System.out.println("No guardo");
			}
	}
		
	}
		

	@Override
	public void upDateDepartment(Department d) {
		if(d.getModifieddate().equals(Calendar.getInstance().getTime())) {
			if(d.getName().length()>=5 && d.getGroupname().length()>=5) {
				Optional<Department> temp = dr.findById(d.getDepartmentid());
				temp.get().setEmployeedepartmenthistories(d.getEmployeedepartmenthistories());
				temp.get().setGroupname(d.getGroupname());
				temp.get().setModifieddate(d.getModifieddate());
				temp.get().setName(d.getName());
				dr.save(temp.get());
			}
		}
		
	}
	
	@Override
	public Department findDepartmentById(Integer id) {
		return dr.findById(id).get();
	}
	
	public Iterable<Department> findAll(){
		return dr.findAll();
	}
	
	public Long size(){
		return dr.count();
	}
	
	public Optional<Department> findDepartment(Integer id) {
		return dr.findById(id);     
		}
	public void updateProduct(Department department, Integer id) {
		Department department1 = dr.findById(id).get();
		
		department1.setName(department.getName());
		department1.setGroupname(department.getGroupname());
		LocalDate date1 = LocalDate.parse(department.getModifieddate1());
		department1.setModifieddate(date1);

		
	}
}
