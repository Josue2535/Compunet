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
	
	EmployeeServiceIMP employeeService;
	
	@Autowired
	public EmployeeController(EmployeeServiceIMP employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> indexEmployee(){
		return employeeService.findAll();
	}
	@PutMapping
	public void updateEmployee(@RequestBody Employee de) {
		employeeService.upDateEmployee(de);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteById(id);
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		Employee temp = employeeService.findEmployeeByiD(id);
		if(temp == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		return employeeService.findEmployeeByiD(id);
	}

	@GetMapping("/search/{date1}/{date2}")
	public List<Employee> getAllBetwenDates(@PathVariable("date1") String date1,@PathVariable("date2") String date2) {
		return employeeService.findBetwenDate(date1.toString(), date2.toString());
	}
	@GetMapping("/search/{date}")
	public List<Employee> getAllByDate(@PathVariable("date1") String date1) {
		return employeeService.findByDate(date1.toString());
	}
	
	
}
