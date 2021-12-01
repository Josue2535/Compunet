package com.example.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
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
		if(eh.getBusinessentityid() != null) {
			//if(eh.getShift().getStarttime().equals(Calendar.getInstance().getTime())||eh.getShift().getStarttime().before(Calendar.getInstance().getTime())) {
				//if(deoR.findById(eh.getDepartment().getDepartmentid())!=null) {
					if(eh.getModifieddate().equals(LocalDate.now())) {
						System.out.println("guardo history");
						ephR.save(eh);
					}
				//}
			//}
		}
		
	}

	@Override
	public void updateHistoryDepartment(com.example.model.hr.Employeedepartmenthistory historydepartment, Integer id) {
					com.example.model.hr.Employeedepartmenthistory historydepartment1 = ephR.findById(id).get();
					LocalDate date1 = LocalDate.parse(historydepartment.getEnddate1());
					historydepartment1.setEnddate(date1);
					
					LocalDate date2 = LocalDate.parse(historydepartment.getModifieddate1());
					historydepartment1.setModifieddate(date2);
					
	}
	
	public Iterable<com.example.model.hr.Employeedepartmenthistory> findAll(){
		return ephR.findAll();
	}
	
	public Long size(){
		return ephR.count();
	}
	
	public Optional<com.example.model.hr.Employeedepartmenthistory> findDepartmentHistory(Integer id) {
		return ephR.findById(id);   
		}

}
