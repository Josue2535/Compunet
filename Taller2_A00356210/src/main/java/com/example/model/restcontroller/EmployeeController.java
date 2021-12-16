package com.example.model.restcontroller;

import java.sql.Date;
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

import com.example.daoimpl.EmployeeDAOimpl;
import com.example.model.hr.Department;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
@RequestMapping("/api/Employee/")
public class EmployeeController {
	
	EmployeeDAOimpl employeeService;
	PersonServiceIMPL personService;
	EmployeepayhistoryServiceIMPL employeehistorypayService;
	
	@Autowired
	public EmployeeController(EmployeeDAOimpl employeeService, EmployeepayhistoryServiceIMPL employeehistorypayService, PersonServiceIMPL personService) {
		this.employeeService = employeeService;
		this.personService = personService;
		this.employeehistorypayService = employeehistorypayService;
	}
	
	@GetMapping
	public Iterable<Employee> indexDepartment() {
		return employeeService.getAll();
	}
	@PutMapping
	public void updateAutotransition(@RequestBody Employee de) {
		employeeService.update(de);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		employeeService.deleteById(id);
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") Integer id) {
		return employeeService.get(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}

	@GetMapping("/search/betwendates")
	public List<Employee> getAllByDates(@RequestParam("date1") Date date1,@RequestParam("date2") Date date2) {
		return employeeService.findBetwenDate(date1.toString(), date2.toString());
	}
	@GetMapping("/search/date")
	public List<Employee> getAllByNameGroup(@RequestParam("date1") Date date1) {
		return employeeService.findByDate(date1.toString());
	}
	
	
}
