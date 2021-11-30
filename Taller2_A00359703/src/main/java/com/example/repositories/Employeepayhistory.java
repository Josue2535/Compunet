package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

import com.example.model.hr.Employeedepartmenthistory;
import com.example.model.hr.EmployeepayhistoryPK;
@Repository
public interface Employeepayhistory extends CrudRepository<com.example.model.hr.Employeepayhistory, Integer>{

}
