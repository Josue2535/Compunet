package com.example.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeedepartmenthistoryDAO;
import com.example.daoimpl.DepartmentDAOimpl;
import com.example.daoimpl.EmployeedepartmenthistoryDAOimpl;
import com.example.model.hr.Employee;
import com.example.repositories.Department;
import com.example.repositories.Employeedepartmenthistory;

@Service
public class EmployeedepartmenthistoryServiceIMPL implements com.example.services.EmployeedepartmenthistoryService{
	private EmployeedepartmenthistoryDAOimpl deoR;
	@Autowired
	public EmployeedepartmenthistoryServiceIMPL( EmployeedepartmenthistoryDAOimpl deoR) {
		this.deoR = deoR;

	}



	@Override
	public void saveHistory( com.example.model.hr.Employeedepartmenthistory eh) {
		if(eh.getBusinessentityid() != null) {
			if(eh.getShift().getStarttime().equals(Calendar.getInstance().getTime())||eh.getShift().getStarttime().before(Calendar.getInstance().getTime())) {
				if(deoR.get(eh.getDepartment().getDepartmentid())!=null) {
					if(eh.getModifieddate().equals(LocalDate.now())) {
						System.out.println("guardo history");
						deoR.save(eh);
					}
				}
			}
		}
		
	}

	@Override
	public void updateHistoryDepartment(com.example.model.hr.Employeedepartmenthistory historydepartment) {
					deoR.update(historydepartment);
					
	}
	
	public List<com.example.model.hr.Employeedepartmenthistory> findAll(){
		return deoR.getAll();
	}
	
	public Long size(){
		return (long) deoR.getAll().size();
	}
	
	public com.example.model.hr.Employeedepartmenthistory findDepartmentHistory(Integer id) {
		return deoR.get(id).get();   
	}



	public void update(com.example.model.hr.Employeedepartmenthistory de) {
		// TODO Auto-generated method stub
		deoR.update(de);
	}



	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		deoR.deleteById(id);
	}

}
