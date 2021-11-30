package com.example.model.controller;

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
import com.example.services.DepartmentServiceIMPL;
import com.example.services.EmployeedepartmenthistoryServiceIMPL;


@Controller
public class OperatorController {
	
	DepartmentServiceIMPL departmentService;
	EmployeedepartmenthistoryServiceIMPL historydepartment;
	
	@Autowired
	public OperatorController(DepartmentServiceIMPL departmentService, EmployeedepartmenthistoryServiceIMPL historydepartment) {
		this.departmentService = departmentService;
		this.historydepartment = historydepartment;
	}
	
	@GetMapping("/departments/")
	public String indexPerson(Model model) {
		
		model.addAttribute("department", departmentService.findAll());
		
		return "operator/indexDepartments";
	}
	
	@GetMapping("/department/add/")
	public String departmentAdd(Model model) {
		
		Department d = new Department();
		
		model.addAttribute("department", d);

		
		return "operator/addDepartments";
	}
	
	@PostMapping("/department/add/post")	
	public String addDeparment(@ModelAttribute("department") Department department, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException {
		
		if(bindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("error", "Error al guardar");
			System.out.println("Error");
			return "/departments/";
		}
		
		
		LocalDate date1 = LocalDate.parse(department.getModifieddate1());
		
		department.setModifieddate(date1);
		department.setDepartmentid(Math.toIntExact(departmentService.size()+1));
		departmentService.saveDepartment(department);
		Department a = departmentService.findDepartmentById(1);
		System.out.println(a.getName());
		redirectAttrs.addFlashAttribute("success", "Agregado correctamente");
		
		
		
		return "redirect:/departments/";
	}
	
	@GetMapping("department/updateDepartments/{id}")     
	public String updateDepartments(@PathVariable("id")Integer id, Model model) {
		Optional<Department> department = departmentService.findDepartment(id);
		if(department.isEmpty())
			throw new IllegalArgumentException("Product ID doesnt exists" + id);
		model.addAttribute("department", department.get()); 
		return "operator/updateDepartments";     
	}
	
	@PostMapping("/department/updateDepartments/{id}")     
	public String updateDepartments(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Department department, BindingResult bindingResult, Model model) throws Exception {
		if(bindingResult.hasErrors()) {             
			model.addAttribute("department", departmentService.findAll());
			return "operator/indexDepartments";         
		}                  
		if(action != null && !action.equals("Cancel")) {             
			departmentService.updateProduct(department, id);             
			model.addAttribute("departments", departmentService.findAll());         
			
		}                 
		return "redirect:/departments/";    
	}
	
	@GetMapping("/historydepartments/")
	public String indexHistoryPay(Model model) {
		
		//model.addAttribute("historydepartment",);
		
		return "admin/indexHistoryPay";
	}
	
	
	
}
