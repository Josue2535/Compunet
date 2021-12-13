package com.example.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoimpl.EmployeeDAOimpl;
import com.example.daoimpl.EmployeepayhistoryDAOimpl;
import com.example.model.hr.Department;
import com.example.repositories.Employee;
import com.example.repositories.Employeepayhistory;
@Service
public class EmployeepayhistoryServiceIMPL implements com.example.services.EmployeepayhistoryService{
	private EmployeepayhistoryDAOimpl employPayHistoriR;
	private EmployeeDAOimpl employR;
	@Autowired
	public EmployeepayhistoryServiceIMPL(EmployeepayhistoryDAOimpl employPayHistoriR,EmployeeDAOimpl employR) {
		this.employPayHistoriR = employPayHistoriR;
		this.employR = employR;
	}
	@Override
	public void savePayHistory( com.example.model.hr.Employeepayhistory eh) {
		if(employR.get(eh.getEmployee().getBusinessentityid())!=null) {
			if(eh.getRate().intValue()>0) {
				if(eh.getModifieddate().equals(LocalDate.now())){
					if(eh.getPayfrequency() == 15 || eh.getPayfrequency() == 30 ) {
						System.out.println("guardo history pay");
						employPayHistoriR.insert(eh);
					}
				}else {
					System.out.println("no guardo history pay");
				}
			}
		}
		
	}
	@Override
	public void updateHistoryPay(com.example.model.hr.Employeepayhistory employeepayhistory, Integer id) {
					com.example.model.hr.Employeepayhistory employeepayhistory1 = employPayHistoriR.get(id).get();
					LocalDate date1 = LocalDate.parse(employeepayhistory.getModifieddate1());
					employeepayhistory1.setModifieddate(date1);
					employeepayhistory1.setPayfrequency(employeepayhistory.getPayfrequency());
					
	}
	
	@Override
	public Optional<com.example.model.hr.Employeepayhistory> findPayHistoryById(Integer id) {
		return employPayHistoriR.get(id);
	}
	public Iterable<com.example.model.hr.Employeepayhistory> findAll(){
		return employPayHistoriR.findAll();
	}
	
	public Long size(){
		return (long) employPayHistoriR.findAll().size();
	}
}
