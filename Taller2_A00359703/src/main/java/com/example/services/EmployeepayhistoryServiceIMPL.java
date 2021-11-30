package com.example.services;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.Employee;
import com.example.repositories.Employeepayhistory;
@Service
public class EmployeepayhistoryServiceIMPL implements com.example.services.EmployeepayhistoryService{
	private Employeepayhistory employPayHistoriR;
	private Employee employR;
	@Autowired
	public EmployeepayhistoryServiceIMPL(Employeepayhistory employPayHistoriR,Employee employR) {
		this.employPayHistoriR = employPayHistoriR;
		this.employR = employR;
	}
	@Override
	public void savePayHistory( com.example.model.hr.Employeepayhistory eh) {
		if(employR.findById(eh.getEmployee().getBusinessentityid())!=null) {
			if(eh.getRate().intValue()>0) {
				if(eh.getModifieddate().equals(Calendar.getInstance().getTime())){
					if(eh.getPayfrequency() == 15 || eh.getPayfrequency() == 30 ) {
						employPayHistoriR.save(eh);
					}
				}				
			}
		}
		
	}
	@Override
	public void upDatePayHistory( com.example.model.hr.Employeepayhistory eh) {
		if(employR.findById(eh.getEmployee().getBusinessentityid())!=null) {
			if(eh.getRate().intValue()>0) {
				if(eh.getModifieddate().equals(Calendar.getInstance().getTime())){
					if(eh.getPayfrequency() == 15 || eh.getPayfrequency() == 30 ) {
						Optional<com.example.model.hr.Employeepayhistory> temp = employPayHistoriR.findById(eh.getId());
						temp.get().setModifieddate(eh.getModifieddate());
						temp.get().setPayfrequency(eh.getPayfrequency());
						temp.get().setRate(eh.getRate());
						temp.get().setEmployee(eh.getEmployee());
						employPayHistoriR.save(temp.get());
					}
				}				
			}
		}
		
	}
	
	@Override
	public com.example.model.hr.Employeepayhistory findPayHistoryById(Integer id) {
		return employPayHistoriR.findById(id).get();
	}
	public Iterable<com.example.model.hr.Employeepayhistory> findAll(){
		return employPayHistoriR.findAll();
	}
}
