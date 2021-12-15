package com.example.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeedepartmenthistoryDAO;
import com.example.daoimpl.DepartmentDAOimpl;
import com.example.model.hr.Employee;
import com.example.repositories.Department;
import com.example.repositories.Employeedepartmenthistory;

@Service
public class EmployeedepartmenthistoryServiceIMPL implements com.example.services.EmployeedepartmenthistoryService{
	private DepartmentDAOimpl deoR;
	private EmployeedepartmenthistoryDAO eR;
	@Autowired
	public EmployeedepartmenthistoryServiceIMPL(EmployeedepartmenthistoryDAO eR, DepartmentDAOimpl deoR) {
		this.deoR = deoR;
		this.eR = eR;
	}



	@Override
	public void saveHistory( com.example.model.hr.Employeedepartmenthistory eh) {
		if(eh.getBusinessentityid() != null) {
			if(eh.getShift().getStarttime().equals(Calendar.getInstance().getTime())||eh.getShift().getStarttime().before(Calendar.getInstance().getTime())) {
				if(deoR.get(eh.getDepartment().getDepartmentid())!=null) {
					if(eh.getModifieddate().equals(LocalDate.now())) {
						System.out.println("guardo history");
						eR.save(eh);
					}
				}
			}
		}
		
	}

	@Override
	public void updateHistoryDepartment(com.example.model.hr.Employeedepartmenthistory historydepartment, Integer id) {
					com.example.model.hr.Employeedepartmenthistory historydepartment1 = eR.get(id).get();
					LocalDate date1 = LocalDate.parse(historydepartment.getEnddate1());
					historydepartment1.setEnddate(date1);
					
					LocalDate date2 = LocalDate.parse(historydepartment.getModifieddate1());
					historydepartment1.setModifieddate(date2);
					
	}
	
	public Iterable<com.example.model.hr.Employeedepartmenthistory> findAll(){
		return eR.getAll();
	}
	
	public Long size(){
		return (long) eR.getAll().size();
	}
	
	public Optional<com.example.model.hr.Employeedepartmenthistory> findDepartmentHistory(Integer id) {
		return eR.get(id);   
		}

}
