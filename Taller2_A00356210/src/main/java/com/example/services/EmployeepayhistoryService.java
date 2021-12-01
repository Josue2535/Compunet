package com.example.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.hr.Employeepayhistory;
@Service
public interface EmployeepayhistoryService{
	public void savePayHistory(Employeepayhistory eh);
	public Optional<Employeepayhistory> findPayHistoryById(Integer id);
	void updateHistoryPay(Employeepayhistory employeepayhistory, Integer id);
}
