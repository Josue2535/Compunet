package com.example.front.Controller;

import java.text.ParseException;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.hr.Employee;

public interface EmployeeController {
	
	public String indexEmployee(Model model);
	public String employeeAdd(Model model);
	public String employeeAdd(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException;
	public String updateEmployee(@PathVariable("id")Integer id, Model model);
	public String updateEmployee(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Employee employee, BindingResult bindingResult, Model model) throws Exception;

}
