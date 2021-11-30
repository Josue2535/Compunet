package com.example.model.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.hr.Department;
import com.example.model.hr.Employee;
import com.example.model.person.Person;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
public class AdministratorController {
	
	EmployeeServiceIMP employeeService;
	EmployeepayhistoryServiceIMPL historypay;
	PersonServiceIMPL personService;
	
	@Autowired
	public AdministratorController(EmployeeServiceIMP employeeService, EmployeepayhistoryServiceIMPL historypay, PersonServiceIMPL personService) {
		this.employeeService = employeeService;
		this.historypay = historypay;
		this.personService = personService;
	}
	//----------------------------------------PERSON----------------------------------------------
	@GetMapping("/person/")
	public String indexPerson(Model model) {
		
		model.addAttribute("person", personService.findAll());
		
		return "admin/indexPerson";
	}
	
	@GetMapping("/person/add/")
	public String personAdd(Model model) {
		
		Person p = new Person();
		model.addAttribute("person", p);

		
		return "admin/addPerson";
	}
	@PostMapping("/person/add/post")	
	public String personAdd(@ModelAttribute("person") Person person, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException {
		
		if(bindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("error", "Error al guardar");
			System.out.println("Error");
			return "/person/";
		}
		person.setBusinessentityid(Math.toIntExact(personService.size()+1));
		personService.savePerson(person);
		redirectAttrs.addFlashAttribute("success", "Agregado correctamente");
		
		
		
		return "redirect:/person/";
	}
	
	@GetMapping("person/updatePerson/{id}")     
	public String updatePerson(@PathVariable("id")Integer id, Model model) {
		Optional<Person> person = Optional.of(personService.findPersonById(id));
		if(person.isEmpty())
			throw new IllegalArgumentException("Product ID doesnt exists" + id);
		model.addAttribute("person", person.get()); 
		return "admin/updatePerson";     
	}
	
	@PostMapping("/person/updateperson/{id}")     
	public String updatePerson(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Person person, BindingResult bindingResult, Model model) throws Exception {
		if(bindingResult.hasErrors()) {             
			model.addAttribute("person", personService.findAll());
			return "admin/indexPerson";         
		}                  
		if(action != null && !action.equals("Cancel")) {             
			personService.upDatePerson(person,id);             
			model.addAttribute("person", personService.findAll());         
			
		}                 
		return "redirect:/person/";    
	}
	//----------------------------------------------EMPLOYEE--------------------------------------
	@GetMapping("/employee/")
	public String indexEmployee(Model model) {
		
		model.addAttribute("employee", employeeService.findAll());
		
		return "admin/indexEmploy";
	}
	@GetMapping("/employee/add/")
	public String employeeAdd(Model model) {
		
		Employee e = new Employee();
		model.addAttribute("employee", e);

		
		return "admin/addEmployee";
	}
	@PostMapping("/employee/add/post")	
	public String employeeAdd(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException {
		
		if(bindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("error", "Error al guardar");
			System.out.println("Error");
			return "/employee/";
		}
		employee.setBusinessentityid(Math.toIntExact(employeeService.size()+1));
		employeeService.saveEmployee(employee);
		redirectAttrs.addFlashAttribute("success", "Agregado correctamente");
		
		
		
		return "redirect:/employee/";
	}
	@GetMapping("employee/updateEmployee/{id}")     
	public String updateEmployee(@PathVariable("id")Integer id, Model model) {
		Optional<Employee> employee = Optional.of(employeeService.findEmployeeByiD(id));
		if(employee.isEmpty())
			throw new IllegalArgumentException("Product ID doesnt exists" + id);
		model.addAttribute("employee", employee.get()); 
		return "admin/updateEmployee";     
	}
	
	@PostMapping("/employee/updateemployee/{id}")     
	public String updateEmployee(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Employee employee, BindingResult bindingResult, Model model) throws Exception {
		if(bindingResult.hasErrors()) {             
			model.addAttribute("person", personService.findAll());
			return "admin/indexPerson";         
		}                  
		if(action != null && !action.equals("Cancel")) {             
			employeeService.upDateEmployee(employee, id);             
			model.addAttribute("employee", employeeService.findAll());         
			
		}                 
		return "redirect:/employee/";    
	}
	@GetMapping("/historypay/")
	public String indexHistoryPay(Model model) {
		
		model.addAttribute("historyPay", historypay.findAll());
		
		return "admin/indexHistoryPay";
	}
	
	
	
}
