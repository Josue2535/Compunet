package com.example.services;

import org.springframework.stereotype.Service;

import com.example.model.hr.Employeepayhistory;
@Service
public interface EmployeepayhistoryService{
	public void savePayHistory(Employeepayhistory eh);
	public void upDatePayHistory( Employeepayhistory eh);
	public Employeepayhistory findPayHistoryById(Integer id);
}
