package com.example.services;

import org.springframework.stereotype.Service;

import com.example.model.hr.Employeedepartmenthistory;
@Service
public interface EmployeedepartmenthistoryService {
	public void saveHistory( Employeedepartmenthistory eh);
	void updateHistoryDepartment(Employeedepartmenthistory historydepartment, Integer id);
}
