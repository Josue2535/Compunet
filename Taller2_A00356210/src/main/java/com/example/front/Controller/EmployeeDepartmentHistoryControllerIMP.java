package com.example.front.Controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.hr.Department;
import com.example.model.hr.Employeedepartmenthistory;
import com.example.model.person.Person;
import com.example.services.DepartmentServiceIMPL;
import com.example.services.EmployeedepartmenthistoryServiceIMPL;


@Controller
public class EmployeeDepartmentHistoryControllerIMP implements EmployeeDepartmentHistoryController{
	
	EmployeedepartmenthistoryServiceIMPL historydepartment;
	
	@Autowired
	public EmployeeDepartmentHistoryControllerIMP(EmployeedepartmenthistoryServiceIMPL historydepartment) {
		this.historydepartment = historydepartment;
	}
	
	//-----------------------------------HistoryDepartments----------------------------------------
	
	@GetMapping("/historydepartments/")
	public String indexHistoryDepartment(Model model) {
		
		model.addAttribute("historydepartment", historydepartment.findAll());
		
		return "operator/indexHistoryDepartment";
	}
	
	@GetMapping("/historydepartments/add/")
	public String historyDepartment(Model model) {
		
		Employeedepartmenthistory d = new Employeedepartmenthistory();
		
		model.addAttribute("historydepartment", d);
		
		return "operator/addHistoryDepartment";
	}
	
	@PostMapping("/historydepartments/add/post")	
	public String addHistoryDeparment(@ModelAttribute("historydepartment") Employeedepartmenthistory historydepartment1, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException {
		
		if(bindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("error", "Error al guardar");
			System.out.println("Error");
			return "/historydepartments/";
		}
		
		LocalDate date1 = LocalDate.parse(historydepartment1.getModifieddate1());
		LocalDate date2 = LocalDate.parse(historydepartment1.getEnddate1());
		
		historydepartment1.setModifieddate(date1);
		historydepartment1.setEnddate(date2);
		historydepartment1.setBusinessentityid(Math.toIntExact(historydepartment.size()+1));
		historydepartment.saveHistory(historydepartment1);
		redirectAttrs.addFlashAttribute("success", "Agregado correctamente");
		return "redirect:/historydepartments/";
	}
	
	@GetMapping("historydepartments/updateHistoryDepartment/{id}")     
	public String updateHistoryDepartment(@PathVariable("id")Integer id, Model model) {
		Employeedepartmenthistory historydepartmenta = historydepartment.findDepartmentHistory(id);
		if(historydepartmenta == null)
			throw new IllegalArgumentException("Department ID doesnt exists" + id);
		model.addAttribute("historydepartment", historydepartmenta); 
		return "operator/updateHistoryDepartment";     
	}
	
	@PostMapping("/historydepartments/updateHistoryDepartment/{id}")     
	public String updateHistoryDepartment(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Employeedepartmenthistory historydepartmenta, BindingResult bindingResult, Model model) throws Exception {
		if(bindingResult.hasErrors()) {             
			model.addAttribute("historydepartment", historydepartment.findAll());
			return "operator/indexDepartments";         
		}                  
		if(action != null && !action.equals("Cancel")) {             
			historydepartment.update(historydepartmenta);             
			model.addAttribute("historydepartment", historydepartment.findAll());         
			
		}                 
		return "redirect:/historydepartments/";    
	}
}
