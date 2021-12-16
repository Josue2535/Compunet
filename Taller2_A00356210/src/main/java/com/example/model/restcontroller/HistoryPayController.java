package com.example.model.restcontroller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.daoimpl.EmployeepayhistoryDAOimpl;
import com.example.model.hr.Department;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeedepartmenthistory;
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
@RequestMapping("/api/historypay/")
public class HistoryPayController {

	EmployeepayhistoryServiceIMPL employeehistorypayService;
	
	@Autowired
	public HistoryPayController(EmployeepayhistoryServiceIMPL employeehistorypayService) {

		this.employeehistorypayService = employeehistorypayService;
	}
	
	
	@GetMapping
	public List<Employeepayhistory> indexDepartmentHistory() {
		return employeehistorypayService.findAll();
	}
	@PutMapping
	public void updateDepartment(@RequestBody Employeepayhistory de) {
		employeehistorypayService.updateHistoryPay(de);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		employeehistorypayService.deleteById(id);
	}

	@GetMapping("/{id}")
	public Employeepayhistory getById(@PathVariable("id") Integer id) {
		return employeehistorypayService.findPayHistoryById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}
	
	
	
}
