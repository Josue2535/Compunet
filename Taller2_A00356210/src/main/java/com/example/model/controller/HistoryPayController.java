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
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;
import com.example.services.EmployeeServiceIMP;
import com.example.services.EmployeepayhistoryServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
public class HistoryPayController {
	
	EmployeeServiceIMP employeeService;
	PersonServiceIMPL personService;
	EmployeepayhistoryServiceIMPL employeehistorypayService;
	
	@Autowired
	public HistoryPayController(EmployeeServiceIMP employeeService, EmployeepayhistoryServiceIMPL employeehistorypayService, PersonServiceIMPL personService) {
		this.employeeService = employeeService;
		this.personService = personService;
		this.employeehistorypayService = employeehistorypayService;
	}
	
	
	@GetMapping("/historypay/")
	public String indexHistoryPay(Model model) {
		
		model.addAttribute("historypaya", employeehistorypayService.findAll());
		
		return "admin/indexHistoryPay";
	}
	
	@GetMapping("/historypay/add/")
	public String historyAdd(Model model) {
		
		Employeepayhistory e = new Employeepayhistory();
		model.addAttribute("historypaya", e);

		
		return "admin/addHistorypay";
	}
	
	@PostMapping("/historypay/add/post")	
	public String historyAdd(@ModelAttribute("historypaya") Employeepayhistory employeehistorypay, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException {
		
		if(bindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("error", "Error al guardar");
			System.out.println("Error");
			return "/historypay/";
		}
		LocalDate date1 = LocalDate.parse(employeehistorypay.getModifieddate1());
		employeehistorypay.setModifieddate(date1);
		employeehistorypay.setId(Math.toIntExact(employeehistorypayService.size()+1));
		employeehistorypayService.savePayHistory(employeehistorypay);
		//System.out.println(employeehistorypayService.findPayHistoryById(1).getModifieddate());
		redirectAttrs.addFlashAttribute("success", "Agregado correctamente");
		
		
		
		return "redirect:/historypay/";
	}
	
	@GetMapping("/historypay/updateHistoryPay/{id}")     
	public String updateHistory(@PathVariable("id")Integer id, Model model) {
		Optional<Employeepayhistory> employepayhistory1 = employeehistorypayService.findPayHistoryById(id);
		if(employepayhistory1.isEmpty())
			throw new IllegalArgumentException("Department ID doesnt exists" + id);
		model.addAttribute("historypay", employepayhistory1.get()); 
		return "admin/updateHistoryPay";     
	}
	
	@PostMapping("/historypay/updateHistoryPay/{id}")     
	public String updateHistory(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Employeepayhistory employeepayhistory1, BindingResult bindingResult, Model model) throws Exception {
		if(bindingResult.hasErrors()) {             
			model.addAttribute("historypaya", employeehistorypayService.findAll());
			return "admin/indexHistorypay";         
		}                  
		if(action != null && !action.equals("Cancel")) {             
			employeehistorypayService.updateHistoryPay(employeepayhistory1, id);             
			model.addAttribute("historypaya", employeehistorypayService.findAll());         
			
		}                 
		return "redirect:/historypay/";    
	}
	
	
	
}
