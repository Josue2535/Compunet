package com.example.services;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.hr.Employee;
import com.example.repositories.Department;
import com.example.repositories.Employeedepartmenthistory;

@Service
public class EmployeedepartmenthistoryServiceIMPL implements com.example.services.EmployeedepartmenthistoryService{
	private Department deoR;
	private Employeedepartmenthistory ephR;
	private com.example.repositories.Employee ER;
	@Autowired
	public EmployeedepartmenthistoryServiceIMPL(Department deoR, Employeedepartmenthistory ephR,
			com.example.repositories.Employee eR) {
		this.deoR = deoR;
		this.ephR = ephR;
		ER = eR;
	}



	@Override
	public void saveHistory( com.example.model.hr.Employeedepartmenthistory eh) {
		if(ER.findById(eh.getEmployee().getBusinessentityid())!=null) {
			if(eh.getShift().getStarttime().equals(Calendar.getInstance().getTime())||eh.getShift().getStarttime().before(Calendar.getInstance().getTime())) {
				if(deoR.findById(eh.getDepartment().getDepartmentid())!=null) {
					if(eh.getEnddate().after(eh.getShift().getStarttime())&&eh.getShift().getModifieddate().equals(Calendar.getInstance().getTime())) {
						ephR.save(eh);
					}
				}
			}
		}
		
	}

	@Override
	public void upDateHistory( com.example.model.hr.Employeedepartmenthistory eh) {
		if(ER.findById(eh.getEmployee().getBusinessentityid())!=null) {
			if(eh.getShift().getStarttime().equals(Calendar.getInstance().getTime())||eh.getShift().getStarttime().before(Calendar.getInstance().getTime())) {
				if(deoR.findById(eh.getDepartment().getDepartmentid())!=null) {
					if(eh.getEnddate().after(eh.getShift().getStarttime())&&eh.getShift().getModifieddate().equals(Calendar.getInstance().getTime())) {
						Optional<com.example.model.hr.Employeedepartmenthistory> temp = ephR.findById(eh.getId());
						temp.get().setDepartment(eh.getDepartment());
						temp.get().setEmployee(eh.getEmployee());
						temp.get().setEnddate(eh.getEnddate());
						temp.get().setModifieddate(eh.getModifieddate());
						temp.get().setShift(eh.getShift());
						ephR.save(temp.get());
					}
				}
			}
		}
		
	}
	
	public Iterable<com.example.model.hr.Employeedepartmenthistory> findAll(){
		return ephR.findAll();
	}

}
