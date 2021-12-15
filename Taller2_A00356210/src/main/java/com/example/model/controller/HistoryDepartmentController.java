package com.example.model.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.daoimpl.DepartmentDAOimpl;
import com.example.daoimpl.EmployeedepartmenthistoryDAOimpl;
import com.example.model.hr.Department;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeedepartmenthistory;
import com.example.model.person.Person;
import com.example.services.DepartmentServiceIMPL;
import com.example.services.EmployeedepartmenthistoryServiceIMPL;


@Controller
public class HistoryDepartmentController {
	
	DepartmentDAOimpl departmentService;
	EmployeedepartmenthistoryDAOimpl historydepartment;
	
	@Autowired
	public HistoryDepartmentController(DepartmentDAOimpl departmentService, EmployeedepartmenthistoryDAOimpl historydepartment) {
		this.departmentService = departmentService;
		this.historydepartment = historydepartment;
	}
	
	@GetMapping
	public Iterable<Employeedepartmenthistory> indexDepartmentHistory() {
		return historydepartment.getAll();
	}
	@PutMapping
	public void updateDepartment(@RequestBody Employeedepartmenthistory de) {
		historydepartment.update(de);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		historydepartment.deleteById(id);
	}

	@GetMapping("/{id}")
	public Employeedepartmenthistory getById(@PathVariable("id") Long id) {
		return historydepartment.get(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}
}