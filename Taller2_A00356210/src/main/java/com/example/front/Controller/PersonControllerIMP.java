package com.example.front.Controller;

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
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
public class PersonControllerIMP implements PersonController{
	
	PersonServiceIMPL personService;
	
	@Autowired
	public PersonControllerIMP(PersonServiceIMPL personService) {
		this.personService = personService;
	}
	//----------------------------------------Person----------------------------------------------
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
			personService.upDatePerson(person);         
			model.addAttribute("person", personService.findAll());         
			
		}                 
		return "redirect:/person/";    
	}
	
	
	
}
