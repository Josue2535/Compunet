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
						employPayHistoriR.save(eh);
					}
				}else {
					System.out.println("no guardo history pay");
				}
			}
		}
		
	}
	@Override
	public void updateHistoryPay(com.example.model.hr.Employeepayhistory employeepayhistory) {
		if(employR.get(employeepayhistory.getEmployee().getBusinessentityid())!=null) {
			if(employeepayhistory.getRate().intValue()>0) {
				if(employeepayhistory.getModifieddate().equals(LocalDate.now())){
					if(employeepayhistory.getPayfrequency() == 15 || employeepayhistory.getPayfrequency() == 30 ) {
						System.out.println("guardo history pay");
						employPayHistoriR.update(employeepayhistory);
					}
				}else {
					System.out.println("no guardo history pay");
				}
			}
		}
					
	}
	
	@Override
	public Optional<com.example.model.hr.Employeepayhistory> findPayHistoryById(Integer id) {
		return employPayHistoriR.get(id);
	}
	public Iterable<com.example.model.hr.Employeepayhistory> findAll(){
		return employPayHistoriR.getAll();
	}
	
	public Long size(){
		return (long) employPayHistoriR.getAll().size();
	}
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		employPayHistoriR.deleteById(id);
	}
}
