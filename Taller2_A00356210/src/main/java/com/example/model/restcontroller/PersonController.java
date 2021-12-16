package com.example.model.restcontroller;

import java.text.ParseException;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.daoimpl.PersonDAOimpl;
import com.example.model.hr.Department;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
public class PersonController {
	
	PersonDAOimpl personService;
	
	@Autowired
	public PersonController(PersonDAOimpl personService) {
		this.personService = personService;
	}
	//----------------------------------------PERSON----------------------------------------------
	@GetMapping
	public Iterable<Person> indexDepartmentHistory() {
		return personService.getAll();
	}
	@PutMapping
	public void updateDepartment(@RequestBody Person de) {
		personService.update(de);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		personService.deleteById(id);
	}

	@GetMapping("/{id}")
	public Person getById(@PathVariable("id") Integer id) {
		return personService.get(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}
	
	
	
}
